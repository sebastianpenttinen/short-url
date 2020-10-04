<template>
  <div id="app">
    <h1>Url Shortener</h1>
    <InputFields />
  </div>
</template>

<script>
import InputFields from "./components/InputFields.vue";

export default {
  name: "App",
  components: {
    InputFields,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
h1 {
  font-size: 4em;
}
</style>
