import { vShow } from 'vue'
import { createStore } from 'vuex'

const state = {
  filmer: [],
  showtime: [],
  salons: [],
  user: null,
  ticket: { id: "", userId: "", film: "", date: "", time: "", salon: "", seats: 0, price: 0 },
  allTickets:[]
}                         


// mutates state 
const mutations = {
  setFilmer(state, list) {
    state.filmer = list
  },
  setShowtime(state, list) {
    state.showtime = list
  },
  updateShow(state, show) {
    let showtime = state.showtime.filter((showtime) => showtime.id == show.id)[0]
    showtime.availableSeats -= show.bookedSeats
  },

  setSalons(state, list) {
    state.salons = list
  }, 
  setUser(state, user) {
    state.user = user
  },
  setTickets(state, list) {
    state.allTickets = list
  },
  addTicket(state, ticket) {
    state.ticket.push(ticket)
  }

}

// async network requests 
const actions = {
  async fetchFilmer(store) {
    let list = await fetch('/rest/filmer')
    list = await list.json()
    store.commit('setFilmer', list)
  },

  async fetchShowtime(store) {
    let list = await fetch('/rest/showtime')
    list = await list.json()
    console.log(list)
    store.commit('setShowtime', list)
  },
  
  async fetchSalons(store) {
    let list = await fetch('/rest/salons')
    list = await list.json()
    store.commit('setSalons', list)
  },

  async updateShow(store, show) {
    let res = await fetch(
      "/rest/showtime/" + show.id,
      {
        method: "PUT",
        body: JSON.stringify(show)
        
      })
    if (res.ok) {
      store.commit('updateShow', show) 
    }
  },

  async login(store, credentials) {
    let user = await fetch('/api/login', {
      method: 'POST',
      body: JSON.stringify(credentials)
    })
    try {
      user = await user.json()
      console.log(user);
      store.commit('setUser', user)
    } catch {
      console.warn('Fel uppgifter')
    }
    },
  
  async register(store, credentials) {
    let user = await fetch('/api/register', {
      method: 'POST',
      body: JSON.stringify(credentials)
    })
    try {
    user = await user.json()
    console.log(user);
    store.commit('setUser', user)
  } catch {
      console.warn('Fel uppgifter')
    }
  },

  async whoAmI(store) {
    let user = await fetch ('/api/whoami')
    try {
      user = await user.json()
      console.log(user);
      store.commit('setUser', user)
    } catch {
      console.warn('Ej inloggad')
    }
  },

  async fetchTickets(store) {
    let list = await fetch('/rest/ticket')
    list = await list.json()
    store.commit('setTickets',list)
  },

  async addTicket(store, ticket) {   
    console.log(ticket)
    let newTicket = await fetch('/rest/ticket', {
      method: 'POST',
      body: JSON.stringify(ticket)
    })
    try {
      newTicket = await newTicket.json()
      console.log("newTicket", newTicket)
      store.dispatch('fetchTickets', ticket)
    } catch {
      console.warn('Bokningen misslyckades')
    }
  }
}


export default createStore({ state, mutations, actions }) 