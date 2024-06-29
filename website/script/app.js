function toggleDarkMode() {
    const element = document.body;
    element.classList.toggle("dark-mode");
}

















document.addEventListener("DOMContentLoaded", () => {

    const toggleButton = document.getElementsByClassName('toggle-button')[0];
    const navbarLinks = document.getElementsByClassName('navbar-links')[0];

    toggleButton.addEventListener('click', () => {
        navbarLinks.classList.toggle('active')
    })

   const darkModeButton = document.getElementById('dark-toggle-button');
   darkModeButton.addEventListener('click', () => {
        toggleDarkMode();
   });


});

