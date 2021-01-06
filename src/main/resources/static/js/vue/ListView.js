const URL = "/vue/getViewList";

var app = new Vue({
    el: "#list-view",
    data: {
        // データ格納用の空の配列を用意
        wordList:[]
    },
    mounted() {
        axios.get(URL).then(response => (this.wordList = response.data))
    }
});

// コンポーネント（部品）
Vue.component('word-item',{
    props: ['word'],
    template: '<li>{{ word }}</li>'
})