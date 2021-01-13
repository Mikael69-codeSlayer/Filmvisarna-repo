import { createStore } from 'vuex'

const state = {
  filmer: []
}

// mutates state 
const mutations = {
  setFilmer(state, list) {
    state.filmer = list
  }
}

// async network requests 
const actions = {
  async fetchFilmer(store) {
    let list = await fetch('./rest/filmer')
    list = await list.json()

    // debug list
    console.log(list)
    
    store.commit('setFilmer', list)
  }
}


export default createStore({ state, mutations, actions }) 