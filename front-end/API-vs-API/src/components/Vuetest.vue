<template>
  <h2>Hello Vue</h2>

</template>

<script>

    export default {
      name: "Vuetest",
        data:()=>{return{
          testString:""
        }},
      methods:{
        goTestPage(){
          axios.get("http://localhost:8080/home.do")
            .then(response => {
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
