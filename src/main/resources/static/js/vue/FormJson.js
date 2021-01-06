new Vue({
    el: '#input-form',
    data: {
        formData: {}
    },
    created: function(){
        // HTMLに埋め込まれたJSON文字列を取得して、JSON形式にパース
        this.formData = JSON.parse(
            document.getElementById('form-init-data').textContent);

        // 確認用のブラウザコンソール出力
        console.log(this.formData)
    }
});