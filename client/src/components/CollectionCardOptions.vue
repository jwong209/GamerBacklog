<template>
    <div>
      <button v-on:click="openDialogModal()">Open Dialog</button>
      <h1>{{ submittedText }}</h1>
  
      <!-- Use a template ref to call showModal() on element... -->
      <dialog ref="dialogTemplateRef">
        <input
          placeholder="type something..."
          v-model="inputText"
        >
        <button v-on:click="onSubmitText">submit</button>
        <button v-on:click="closeDialogModal()">close</button>
      </dialog>
    </div>
  </template>
  
  <script>
  
  export default {
    data(){
      return {
        inputText: '',
        submittedText: '',
        dialogRef: null
      }
    },
    methods: {
      onSubmitText(){
        this.submittedText = this.inputText;
        this.closeDialogModal();
      },
      openDialogModal() {
        this.dialogRef?.showModal();
      },
      closeDialogModal() {
        this.dialogRef?.close();
      }
    },
    
    // Template ref is only available after mount hook
    // https://vuejs.org/guide/essentials/template-refs.html
    mounted() {
      this.dialogRef = this.$refs.dialogTemplateRef;
    }
  }
  </script>
  
  <style scoped>
    
  /* dialog element has position absolute by default */
  dialog {
    margin: 0 auto;
    top: 50%;
    transform: translateY(-50%);
  }
    
  dialog[open] {
    animation: toggle-modal 1s ease-in-out;
  }
  
  dialog::backdrop {
    background: slategray;
    opacity: 0.2;
  }
    
  @keyframes toggle-modal {
    from {
      opacity: 0;
    }
  
    to {
      opacity: 1;
    }
  }
  </style>
  