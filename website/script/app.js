function toggleDarkMode() {
    const element = document.body;
    element.classList.toggle("dark-mode");
}


/* ----------------  Game Card Creation  ---------------- */
const testArea = document.getElementById('tests');

function createCard(gamesArray, container) {
    // Create outer most div
    const gameCard = document.createElement('div');
    gameCard.classList.add('game-card');

    // Create div for game image
    const gameImage = document.createElement('div');
    gameImage.classList.add('game-image');
    gameImage.style.backgroundImage = `url(${gamesArray.imageName})`;

    // Create div for game data
    const gameData = document.createElement('div');
    gameData.classList.add('game-data-area');

    // Create game name
    const gameName = document.createElement('h3');
    gameName.classList.add('game-name');
    gameName.innerText = gamesArray.name;

    // Create game description
    const gameDescription = document.createElement('p');
    gameDescription.classList.add('game-description');
    gameDescription.innerText = gamesArray.description;

    // Create platforms
    const gamePlatformsHeading = document.createElement('h4');
    gamePlatformsHeading.classList.add('game-data-heading');
    gamePlatformsHeading.innerText = `Platforms:`

    const gamePlatforms = document.createElement('p');
    // gamePlatforms.classList.add('game-data');
    gamePlatforms.innerText = gamesArray.platforms;

    // Create genres
    const gameGenresHeading = document.createElement('h4');
    gameGenresHeading.classList.add('game-data-heading');
    gameGenresHeading.innerText = `Genres:`

    const gameGenres = document.createElement('p');
    // gameGenres.classList.add('game-data');
    gameGenres.innerText = gamesArray.genres;

    // Create developers
    const gameDevelopersHeading = document.createElement('h4');
    gameDevelopersHeading.classList.add('game-data-heading');
    gameDevelopersHeading.innerText = `Developers:`

    const gameDevelopers = document.createElement('p');
    // gameDevelopers.classList.add('game-data');
    gameDevelopers.innerText = gamesArray.developers;

    // Create release date
    const gameReleaseHeading = document.createElement('h4');
    gameReleaseHeading.classList.add('game-data-heading');
    gameReleaseHeading.innerText = `Release date:`

    const gameRelease = document.createElement('p');
    // gameRelease.classList.add('game-data');
    gameRelease.innerText = gamesArray.release;

    // Create price element
    const productPrice = document.createElement('p');
    productPrice.classList.add('product-price');
    productPrice.innerText = `$${gamesArray.price}`;

    // Append child elements to game data
    gameData.appendChild(gameName);
    gameData.appendChild(gamePlatformsHeading);
    gameData.appendChild(gamePlatforms);
    gameData.appendChild(gameGenresHeading);
    gameData.appendChild(gameGenres);
    gameData.appendChild(gameDevelopersHeading);
    gameData.appendChild(gameDevelopers);
    gameData.appendChild(gameReleaseHeading);
    gameData.appendChild(gameRelease);
    // gameData.appendChild(gameDescription);
    // gameData.appendChild(productPrice);

    // Append gameImage and gameData to game card
    gameCard.appendChild(gameImage);
    gameCard.appendChild(gameData);

    // Append gameCard to container
    container.appendChild(gameCard);
}



document.addEventListener("DOMContentLoaded", () => {

    /* ----------------------  ACCORDION TOGGLE  ---------------------- */
    const toggleButton = document.getElementsByClassName('toggle-button')[0];
    const navbarLinks = document.getElementsByClassName('navbar-links')[0];
    
    toggleButton.addEventListener('click', () => {
        navbarLinks.classList.toggle('active')
    })
    
    /* ----------------------  DARK MODE TOGGLE  ---------------------- */
   const darkModeButton = document.getElementById('dark-toggle-button');
   darkModeButton.addEventListener('click', () => {
        toggleDarkMode();
   });

    /* ----------------------  LOGIN MODAL  ---------------------- */
    const modal = document.getElementById('id01');

    // When user clicks outside modal, it closes
    window.onclick = (event)=> {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    /* ----------------------  TEST BUTTON  ---------------------- */
    const testButton = document.getElementById('test-button');
    const testContainer = document.getElementById('tests');

    testButton.addEventListener('click', () => {
        gameFavorites.getGames().forEach(game => {
            createCard(game, testContainer);
        });
    });

    const clearResultsButton = document.getElementById('clear-results-button');
    clearResultsButton.addEventListener('click', () => {
        while (testContainer.children.length > 0) {
            testContainer.removeChild(testContainer.lastElementChild);
        }
    });
    
});

