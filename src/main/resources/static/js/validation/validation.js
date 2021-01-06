const URL = "/validation/check";

new Vue({
    el:'#form-check',
    data:{
        formData:{
            name:'',
            age:'',
            mail:'',
            postAddress:''
        },
        resultMessage:''
    },
    methods:{
        validationCheck:function () {
            axios.post(URL,this.formData).then(response => (this.resultMessage = response.data))
        }
    }
});