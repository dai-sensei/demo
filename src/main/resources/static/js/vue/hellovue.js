// データバインド
var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    }
});

// 属性のバインド
var app2 = new Vue({
    el: '#app2',
    data: {
        message: 'Hello Vue.js!!'
    }
});

// 条件分岐
var app3 = new Vue({
    el: '#app3',
    data: {
        seen: true
    }
});

// 要素の内容をすべて表示
var app4 = new Vue({
    el: '#app4',
    data: {
        todos: [
            {text: "要素1"},
            {text: "要素2"},
            {text: "要素3"}
        ]
    }
});

// イベント発火
var app5 = new Vue({
    el: '#app5',
    data: {
        message: 'Hello Vue.js!!!!!!!'
    },
    methods: {
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
});

// イベント発火（別記述）
var app5_1 = new Vue({
    el: '#app5-1',
    data: {
        message: 'イベント発火テスト'
    },
    methods: {
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
});

// 双方向バインド
var app6 = new Vue({
    el: '#app6',
    data: {
        message: '初期値'
    }
});

// コンポーネント（部品）
Vue.component('todo-item',{
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
});

var app7 = new Vue({
    el: '#app7',
    data:{
        groceryList: [
            {id: 0, text:'出社'},
            {id: 1, text:'おひるごはん'},
            {id: 2, text:'退社'}
        ]
    }
});

// 算出プロパティ
// メソッドとの違いは算出結果がキャッシュされinputとなる情報が変わらない限りキャッシュを返却する
var example = new Vue({
    el: '#example',
    data: {
        message: 'Hello'
    },
    computed: {
        // 算出関数を定義
        reversedMessage: function(){
            return this.message.split('').reverse().join('')
        }
    }
});

new Vue({
    el: '.static',
    data: {
        isActive: true,
        hasError: false
    }
});

new Vue({
    el:'#app8',
    data: {
        awesome: true
    }
});
