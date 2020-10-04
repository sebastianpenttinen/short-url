<template>
  <div class="wrapper">
    <div class="inputs">
      <label class="label">Short Url</label>
      <input class="input-field" v-model="shortUrl" />
      <label class="label">Full Url</label>
      <input class="input-field" v-model="fullUrl" />
    </div>
    <button v-on:click="postNewUrl">Shorten url</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      shortUrl: "",
      fullUrl: "",
    };
  },
  methods: {
    postNewUrl() {
      console.log("test");
      axios
        .post("/api/v1/save", {
          fullUrl: this.fullUrl,
          shortUrl: this.shortUrl,
        })
        .then(() => {
          this.reset();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    reset() {
      this.shortUrl = "";
      this.fullUrl = "";
    },
  },
};
</script>
<style>
.wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.inputs {
  flex-direction: column;
  display: flex;
}
.label {
  align-self: start;
  margin-top: 0.5em;
  font-size: 1em;
}

button {
  margin-top: 0.5em;
}
</style>
