import { createStore } from 'vuex'

const state = {
  filmer: [],
  showtime: [],
  user: null
}

// mutates state 
const mutations = {
  setFilmer(state, list) {
    state.filmer = list
  },
  setShowtime(state, list) {
    state.showtime = list
  }, 
  setUser(state, user) {
    state.user = user
  }
}

// async network requests 
const actions = {
  async fetchFilmer(store) {
    let list = await fetch('/rest/filmer')
    list = await list.json()

    // debug list
    console.log(list)
    
    store.commit('setFilmer', list)
  },

  async fetchShowtime(store) {
    let list = await fetch('/rest/showtime')
    list = await list.json()

    console.log(list)

    store.commit('setShowtime', list)
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
    let user = await fetch ('/api/whoami/')
    try {
      user = await user.json()
      console.log(user);
      store.commit('setUser', user)
    } catch {
      console.warn('Ej inloggad')
    }
  }
}


export default createStore({ state, mutations, actions }) 