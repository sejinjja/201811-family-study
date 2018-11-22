
import axios from 'axios'

export default {
  getList() {
    return axios.get('http://192.168.35.254:20110/todo/v1/getList').then((res)=>{
      return res.data
    })
  },
  updateList(updateList) {
    return axios.post('http://192.168.35.254:20110/todo/v1/updateList', updateList).then((res)=>{
      return res.data
    })
  },
  deleteList(deleteList) {
    return axios.post('http://192.168.35.254:20110/todo/v1/deleteList', deleteList).then((res)=>{
      return res.data
    })
  }
}