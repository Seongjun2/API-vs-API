<template>
  <div>
  <h2>Hello Vue</h2>
  <h2>{{testString}}</h2>
  </div>
</template>

<script>
    import axios from 'axios'
    export default {
      data:()=>{return{
          testString:""
        }},
      created() {
        this.goTestPage()
      },
      methods:{
        goTestPage(){
          axios.get("http://192.168.35.21:8080/home.do").then(response => {
            console.log(response)
              this.testString = response.data
            })
            .catch(e => {
              console.log(e)
            })
        }
      }
    }


</script>

<style scoped>

</style>
