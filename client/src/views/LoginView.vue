<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <img src="../assets/img/site-logo.png">
      <div id="heading">
        <h2 class="press-start-2p-regular">Login</h2>
        <p>Welcome back! Please login to continue</p>
      </div>
      <div id="fields">
        <div class="form-item">
          <label for="username"><strong>Username</strong></label><br>
          <input type="text" id="username" placeholder="Username" v-model="user.username" required autofocus />
        </div>
        <div class="form-item">
          <label for="password"><strong>Password</strong></label><br>
          <input type="password" id="password" placeholder="Password" v-model="user.password" required />
        </div>
        <div class="form-item"><button type="submit" class="primary">Login</button></div>
        <hr/>
      </div>
      <div id="register-option">
        Need an account? <router-link v-bind:to="{ name: 'register' }">Register!</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (!response) {
            alert(error);
          } else if (response.status === 401) {
            alert("Invalid username and password!");
          } else {
            alert(response.message);
          }
        });
    },
  },
};
</script>

<style scoped>
#login {
  background-image: linear-gradient(rgba(56, 31, 138, 0.9), rgba(140, 64, 191, 0.5)), url('../assets/img/thomas-despeyroux-i_qs6f6y8ag-unsplash.jpg');
  background-size: cover;
  background-position: top;
  background-repeat: no-repeat;
  background-attachment: fixed;
  min-height: 100dvh;
  display: flex;
  justify-content: center;
  align-items: center;
}

#heading {
  text-align: center;
  margin: 0 auto 20px;
}

form {
  background-color: rgb(231, 231, 231);
  width: 600px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  border-radius: 8px;
  padding: 50px 80px;
}

form img {
  width: 50%;
  margin: 0 auto;
}

.form-item {
  margin-bottom: 25px;
}
.form-item input {
  width: 100%;
}

form button {
  width: 100%;
}

#register-option {
  text-align: center;
}
</style>
