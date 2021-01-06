var childComponent = Vue.component('item-col', {
    props: ['item', 'index'],
    template: '<tr>' +
        '<td>{{index}}</td>' +
        '<td><input type="text" v-bind:name="\'itemList[\'+index+\'].itemNumber\'" v-model="item.itemNumber"/></td>' +
        '<td><input type="text" v-bind:name="\'itemList[\'+index+\'].itemName\'" v-model="item.itemName"/></td>' +
        '<td><input type="text" v-bind:name="\'itemList[\'+index+\'].itemDetail.price\'" v-model="item.itemDetail.price"/></td>' +
        '<td><input type="text" v-bind:name="\'itemList[\'+index+\'].itemDetail.stock\'" v-model="item.itemDetail.stock"/></td>' +
        '<td><input type="button" v-on:click="click(index)" value="削除"/></td>' +
        '</tr>',
    methods: {
        click: function (index) {
            console.log("子要素のevent発火 index:" + index);
            // 親のメソッドにイベントを伝搬する（伝搬するためのイベント名,メソッド引数）
            this.$emit('child-delete', index)
        }
    }
});

new Vue({
    el: '#input-form',
    data: {
        formData: {}
    },
    created: function () {
        this.formData = JSON.parse(
            document.getElementById('json-data').textContent);
    },
    methods: {
        add: function () {
            var addData = {
                "itemNumber": "",
                "itemName": "",
                "itemDetail": {
                    "price": "",
                    "stock": ""
                },
                "availability": true
            };
            this.formData.itemList.push(addData);
        },
        dataDelete: function (index) {
            // 確認用出力
            console.log("親のメソッドを実行");
            console.log("index:" + index);

            // indexに指定された配列番号の要素を削除
            this.formData.itemList.splice(index, 1)
        }
    }
});