<template>
    <div>
        <div v-show="isInit">
            <div>추가하기</div>
            <div>할일 : 
                <input v-model="todoText" @keyup.enter="todoRegist()" type="text">
                <button @click="todoRegist()">등록</button>
            </div>
            <br><hr><br>
            <div>할 일 목록들</div>
            <div>
                <div v-for="(todo, idx) in todoList"
                style="width: 800px;
                display:flex;
                margin: auto;
                align-items:center;
                justify-content: space-between;">
                    <input style="margin:10px 10px 0;" type="checkbox" v-model="todo.done" :false-value="0" :true-value="1">
                    <span style="margin: 10px 10px 0;">{{createdDate(todo.createDate)}}</span>
                    <input style="margin: 10px 10px 0;dispaly: flex; flex:1 1 auto;" :disabled="todo.done === 1" :class="{strike: todo.done}" v-model="todo.todoText"/>
                    <button style="margin: 10px 10px 0;" @click="todoDelete(todo)">삭제</button>
                </div>
            </div>
            <br><hr><br>
            <button @click="save()">변경 내용 저장</button>
        </div>
    </div>
</template>

<script>
    import '@/assets/common.css'
    import _ from 'lodash'
    import req2svr from './req2svr'
    import moment from 'moment'

    moment.lang('ko', {
        weekdays: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
        weekdaysShort: ["일","월","화","수","목","금","토"],
    });


    export default {
        name: "todo",
        data() {
            return {
                todoText: '',
                todoList: [],
                isInit: false,
                deleteTodoList: []
            }
        },
        computed: {
            req2svr: () => req2svr
        },
        created(){
            this.req2svr.getList().then((res)=>{
                if(res.code === 200)
                    this.todoList = res.payload
                this.isInit = true
            })
        },    
        methods:{
            save() {
                this.req2svr.deleteList(this.deleteTodoList).then((res)=>{
                    if(res.code === 200)
                        this.deleteTodoList = []
                })
                this.req2svr.updateList(this.todoList).then((res)=>{
                    if(res.code === 200)
                        this.todoList = res.payload
                })
            },
            todoDelete(todo){
                this.deleteTodoList = this.deleteTodoList.concat(_.remove(this.todoList, todo))
                this.$forceUpdate()
            },
            createdDate(date){
                if(!date)
                    return ''
                return moment(date).format('YYYY-MM-DD (ddd) HH:mm:ss')
            },
            todoRegist() {
                if(this.todoText.trim()) {
                    this.todoList.push({
                        todoText: this.todoText,
                        done: 0,
                        todoId: undefined
                    })
                    this.todoText = ''
                }
            }
        }
    }
</script>

