<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal" role="dialog" aria-labelledby="modalTitle" aria-describedby="modalDescription">
        <header class="modal-header" id="modalTitle">
          <slot name="header">Edit Backlog Status</slot>
          <button type="button" class="btn-close" @click="close" aria-label="Close modal">x</button>
        </header>

        <section class="modal-body" id="modalDescription">
          <slot name="body">
            <form v-on:submit.prevent="updateBacklogGame">
              <div id="form-top">
                <label for="priority-form">Priority: </label>
                <select id="priority-form" name="priority-form" v-model="backlogGame.priority">
                  <option value="3">-----</option>
                  <option value="1">1 (Low)</option>
                  <option value="2">2</option>
                  <option value="3">3 (Medium)</option>
                  <option value="4">4</option>
                  <option value="5">5 (High)</option>
                </select>

                <label>Progress: </label>
                <textarea v-model="backlogGame.progress" type="text" placeholder="Enter progress notes">
              </textarea>
              </div>

              <div id="form-bottom">
                <button type="button" class="secondary" @click="close" aria-label="Close modal">Cancel</button>

                <button type="submit" value="Submit" class="primary">Submit</button>
              </div>


              <!-- <input type="reset" value="Reset"> -->
            </form>

          </slot>
        </section>

        <!-- <footer class="modal-footer">
          <slot name="footer">
          </slot>
        </footer> -->
      </div>
    </div>
  </transition>
</template>
  
<script>
import BacklogService from '../services/BacklogService';

export default {
  data() {
    return {
      backlogGame: {
        "backlogId": this.backlogId,
        "gameId": this.selectedGameId,
        "progress": '',
        "priority": null
      },
    }

  },

  computed: {

  },

  props: ['selectedGameId', 'backlogId'],

  methods: {
    close() {
      this.$emit('close');
    },
    updateBacklogGame() {
      BacklogService.updateBacklogGame(this.backlogId, this.selectedGameId, this.backlogGame)
        .then((response) => {
          alert('Successfully updated backlog status');
          this.close();
        })
        .catch((error) => {
          alert('Unable to update backlog status');
        });
    },


  }
};
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: #FFFFFF;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  border-radius: 12px 12px 10px 10px;
}

.modal-header,
.modal-footer {
  padding: 15px;
  /* display: flex; */
}

.modal-header {
  position: relative;
  border-bottom: 1px solid #7c7c7c;
  color: #000000;
  justify-content: space-between;
}

.modal-footer {
  border-top: 1px solid #eeeeee;
  flex-direction: column;
}

.modal-body {
  position: relative;
  padding: 15px;
}



section {
  margin: 0;
  padding: 0;
}


#form-top {
  display: flex;
  flex-direction: column;
  margin-bottom: 15px;
}

#form-bottom {
  display: flex;
  justify-content: flex-end;
  column-gap: 8px;
}

textarea {
  height: 150px;
  width: 350px
}

.btn-close {
  position: absolute;
  top: 0;
  right: 0;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: #4AAE9B;
  background: transparent;
}

.btn-green {
  color: white;
  background: #4AAE9B;
  border: 1px solid #4AAE9B;
  border-radius: 2px;
}

.modal-fade-enter,
.modal-fade-leave-to {
  opacity: 0;
}

.modal-fade-enter-active,
.modal-fade-leave-active {
  transition: opacity .5s ease;
}

.dark-mode {}
</style>
