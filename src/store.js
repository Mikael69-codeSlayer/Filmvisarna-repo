import { createStore } from 'vuex'

const state = {
  filmer: [],
  showtime: [],
  salons: []
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
  }
}

// async network requests 
const actions = {
  async fetchFilmer(store) {
    let list = await fetch('/rest/filmer')
    list = await list.json()

    // debug list
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
  }
}


export default createStore({ state, mutations, actions }) 