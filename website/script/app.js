function toggleDarkMode() {
    const element = document.body;
    element.classList.toggle("dark-mode");
}





document.addEventListener("DOMContentLoaded", () => {

    /* ----------------------  DARK MODE TOGGLE  ---------------------- */
    const toggleButton = document.getElementsByClassName('toggle-button')[0];
    const navbarLinks = document.getElementsByClassName('navbar-links')[0];

    toggleButton.addEventListener('click', () => {
        navbarLinks.classList.toggle('active')
    })

   const darkModeButton = document.getElementById('dark-toggle-button');
   darkModeButton.addEventListener('click', () => {
        toggleDarkMode();
   });

   /* ----------------------  LOGIN MODAL  ---------------------- */
    // Get the modal
    const modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = (event)=> {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }


});

