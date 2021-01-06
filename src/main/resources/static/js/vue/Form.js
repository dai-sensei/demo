new Vue({
    el: '#input-form',
    data: {
        message: ''
    },
    created: function(){
        this.message = document.getElementById('message').value
    }
});