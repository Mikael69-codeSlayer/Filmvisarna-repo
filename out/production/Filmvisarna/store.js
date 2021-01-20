import { createStore } from 'vuex'

const state = {
  filmer: [],
  showtime: []
}

// mutates state 
const mutations = {
  setFilmer(state, list) {
    state.filmer = list
  },
  setShowtime(state, list) {
    state.showtime = list
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
  }
}


export default createStore({ state, mutations, actions }) 