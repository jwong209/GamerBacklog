<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal" role="dialog" aria-labelledby="modalTitle" aria-describedby="modalDescription">
        <header class="modal-header" id="modalTitle">
          <slot name="header">Edit Collection Status</slot>
          <button type="button" class="btn-close" @click="close" aria-label="Close modal"><i class="fa-regular fa-circle-xmark"></i></button>
        </header>

        <section class="modal-body" id="modalDescription">
          <slot name="body">
            <form v-on:submit.prevent="updateCollectionGame">

              <div id="form-top">
                <div class="collection-status-item">
                  <label><strong>Status:</strong></label><br>
                  <input type="radio" id="unplayed" name="status" value="Unplayed" v-model="collectionGame.status">
                  <label for="unplayed">Unplayed</label>
                  <br>
                  <input type="radio" id="currently-playing" name="status" value="Currently playing"
                    v-model="collectionGame.status">
                  <label for="currently-playing">Currently playing</label>
                  <br>
                  <input type="radio" id="completed" name="status" value="Completed" v-model="collectionGame.status">
                  <label for="completed">Completed</label>
                  <br>
                  <input type="radio" id="abandoned" name="status" value="Abandoned" v-model="collectionGame.status">
                  <label for="abandoned">Abandoned</label>
                </div>

                <div class="collection-status-item">
                  <label><strong>Format:</strong></label><br>
                  <input type="radio" id="digital" name="owned-format" value="Digital" v-model="collectionGame.format">
                  <label for="digital">Digital</label>
                  <br>
                  <input type="radio" id="physical" name="owned-format" value="Physical" v-model="collectionGame.format">
                  <label for="physical">Physical</label>

                </div>

                <div class="collection-status-item">
                  <label for="platform-select"><strong>Platform:</strong></label>
                  <br>
                  <select name="platform-selection" id="platform-select" v-model="collectionGame.platform">
                    <option value="">-----</option>
                    <option v-for="platform in platforms" v-bind:key="platform.id" v-bind:value="platform.name">{{
                      platform.name }}</option>
                  </select>
                </div>

                <div class="collection-status-item">
                  <label for="rating-select"><strong>Rating:</strong></label>
                  <br>
                  <select name="rating-selection" id="rating-select" v-model="collectionGame.rating">
                    <option value="">-----</option>
                    <option value="5">5</option>
                    <option value="4">4</option>
                    <option value="3">3</option>
                    <option value="2">2</option>
                    <option value="1">1</option>
                    <!-- apparently icons cannot appear in <option> -->
                  </select>
                </div>

                <div class="collection-status-item">
                  <label><strong>Notes: </strong></label><br>
                  <textarea v-model="collectionGame.notes" type="text" placeholder="Enter notes">
                  </textarea>
                </div>
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
          <slot name="footer">Default Footer</slot>
          <button type="button" class="btn-green" @click="close" aria-label="Close modal">Cancel</button>
        </footer> -->
      </div>
    </div>
  </transition>
</template>
    
<script>
import CollectionService from '../services/CollectionService';

export default {
  data() {
    return {
      collectionGame: {
        "collectionId": this.collectionId,
        "gameId": this.selectedGameId,
        "status": "",
        "platform": "",
        "format": "",
        "rating": null,
        "notes": ""
      }

    }
  },

  props: ['selectedGameId', 'collectionId', 'platforms'],

  methods: {
    close() {
      this.$emit('close');
    },
    updateCollectionGame() {
      this.$emit('updateGameSuccess', { popupText:'Game status updated.' });

      CollectionService.updateCollectionGame(this.collectionId, this.selectedGameId, this.collectionGame)
        .then((response) => {
          // alert('Successfully updated collection status');
          this.close();
        })
        .catch((error) => {
          alert('Unable to update collection status');
        });
    }
    // updateCollectionGame() {
    //   this.$store.dispatch('updateGameInCollection', { collectionId: this.collectionId, currentGameId: this.selectedGameId, collectionGame: this.collectionGame })
    //     .then((response) => {
    //       alert('Successfully updated collection status');
    //       this.close();
    //     })
    //     .catch((error) => {
    //       alert('Unable to update collection status');
    //     });
    // }

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
  display: flex;
}

.modal-header {
  position: relative;
  border-bottom: 1px solid #7c7c7c;
  color: white;
  justify-content: space-between;
}

.modal-footer {
  border-top: 1px solid #eeeeee;
  flex-direction: column;
}

.modal-body {
  position: relative;
  padding: 15px;
  width: 100%;
}

section {
  margin: 0;
  padding: 0;
}

.collection-status-item {
  margin-bottom: 10px;
}

.btn-close {
  position: absolute;
  top: 0;
  right: 0;
  border: none;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: #1b1ba6;
  background: transparent;
}
.btn-close i {
  font-size: 25px;
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
  height: 80px;
  width: 350px
}

.modal-fade-enter,
.modal-fade-leave-to {
  opacity: 0;
}

.modal-fade-enter-active,
.modal-fade-leave-active {
  transition: opacity .5s ease;
}
</style>
  