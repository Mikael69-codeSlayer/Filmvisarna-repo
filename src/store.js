import { createStore } from 'vuex'

const state = {
  filmer: [],
  showtime: [],
  salons: [],
  user: null,
  ticket: {},              //Biljetten som ska skickas till backend, måste ha exakt samma fält som i backend. Samma stavning osv. {customer:{allt i måsvingar är objekt}, seats: är int, ej objekt}
  allTickets:[]          //Kan eventuellt behövas för att hitta historiken av en användares biljetter
}                         

// mutates state 
const mutations = {
  setFilmer(state, list) {
    state.filmer = list
  },
  setShowtime(state, list) {
    state.showtime = list
  },
  setSalons(state, list) {
    state.salons = list
  }, 
  setUser(state, user) {
    state.user = user
  },
  setTickets(state, list) {
    state.allTickets = list               //tar tag i allTickets 
  }
}

// async network requests 
const actions = {
  async fetchFilmer(store) {
    let list = await fetch('/rest/filmer')
    list = await list.json()
    //console.log(list)
    store.commit('setFilmer', list)
  },

  async fetchShowtime(store) {
    let list = await fetch('/rest/showtime')
    list = await list.json()
    //console.log(list)
    store.commit('setShowtime', list)
  },
  
  async fetchSalons(store) {
    let list = await fetch('/rest/salons')
    list = await list.json()
    //console.log(list)
    store.commit('setSalons', list)
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

  async fetchTickets(store) {                                              //hämtar alla tickets
    let list = await fetch('/rest/ticket')
    list = await list.json()

    store.commit('setTickets',list)
  },

  async addTicket(store, ticket) {   
    let newTicket = await fetch('/rest/ticket', {
      method: 'POST',
      body:JSON.stringify(ticket)
    })
    try {
      newTicket = await newTicket.json()
      console.log(newTicket)
      store.dispatch('fetchTickets')
    } catch {
      console.warn("Bokningen misslyckades")
    }
  }
}


export default createStore({ state, mutations, actions }) 