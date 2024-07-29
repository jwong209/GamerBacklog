/* ----------------  DARK MODE  ---------------- */
function toggleDarkMode() {
  const bodyElement = document.body;
  bodyElement.classList.toggle("dark-mode");
}

/* ----------------  BACK TO TOP  ---------------- */
function scrollFunction() {
  let scrollToTopButton = document.getElementById("back-to-top-button");

  if (document.body.scrollTop > 1000 || document.documentElement.scrollTop > 1000) {
    scrollToTopButton.style.display = "block";
  } else {
    scrollToTopButton.style.display = "none";
  }
}

function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

/* ----------------  Game Card Creation  ---------------- */
const testArea = document.getElementById('tests');

function createCard(gameObject, container) {
  // Create outer most div
  const gameCard = document.createElement('div');
  gameCard.classList.add('game-card');

  // Create div for game image ---------------------------------------------------
  const gameImage = document.createElement('div');
  gameImage.classList.add('game-image');
  gameImage.style.backgroundImage = `url(${gameObject.imageName})`;

  // Create div for game data ---------------------------------------------------
  const gameData = document.createElement('div');
  gameData.classList.add('game-data-area');

  // Create game name
  const gameName = document.createElement('h3');
  gameName.classList.add('game-name');
  gameName.innerText = gameObject.name;

  // Create game description
  const gameDescription = document.createElement('p');
  gameDescription.classList.add('game-description');
  gameDescription.innerText = gameObject.description;

  // Create platforms
  const gamePlatformsHeading = document.createElement('h4');
  gamePlatformsHeading.classList.add('game-data-heading');
  gamePlatformsHeading.innerText = `Platforms:`

  const gamePlatforms = document.createElement('p');
  gamePlatforms.innerText = gameObject.platforms;

  // Create genres
  const gameGenresHeading = document.createElement('h4');
  gameGenresHeading.classList.add('game-data-heading');
  gameGenresHeading.innerText = `Genres:`

  const gameGenres = document.createElement('p');
  gameGenres.innerText = gameObject.genres;

  // Create developers
  const gameDevelopersHeading = document.createElement('h4');
  gameDevelopersHeading.classList.add('game-data-heading');
  gameDevelopersHeading.innerText = `Developers:`

  const gameDevelopers = document.createElement('p');
  gameDevelopers.innerText = gameObject.developers;

  // Create release date
  const gameReleaseHeading = document.createElement('h4');
  gameReleaseHeading.classList.add('game-data-heading');
  gameReleaseHeading.innerText = `Release date:`;

  const gameRelease = document.createElement('p');
  gameRelease.innerText = gameObject.release;

  // Create div for game bottom ---------------------------------------------------
  const gameBottom = document.createElement('div');
  gameBottom.classList.add('game-bottom');

  // Create bottom
  const description = document.createElement('button');
  description.classList.add('description-button');
  description.innerText = `View description`;

  const trashIcon = document.createElement('i');
  trashIcon.classList.add('trash-icon', 'fa-solid', 'fa-trash-can');

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
  gameData.appendChild(description);
  gameData.appendChild(trashIcon);

  // Append child elements to game bottom
  gameBottom.appendChild(description);
  gameBottom.appendChild(trashIcon);

  // Append gameImage and gameData to game card
  gameCard.appendChild(gameImage);
  gameCard.appendChild(gameData);
  gameCard.appendChild(gameBottom);

  // Append gameCard to container
  container.appendChild(gameCard);


  /* ----------------------  SHOW DESCRIPTION  ---------------------- */
  description.addEventListener('click', () => {
    alert(gameObject.description);
  });

  /* ----------------------  DELETE GAME CARD  ---------------------- */
  trashIcon.addEventListener('click', () => {
      container.removeChild(gameCard);
  });

}

// -------------------------- FETCH DEMO -----------------------------
const BASE_URL = 'https://jsonplaceholder.typicode.com';

function addButtonListeners() {
  document.getElementById('btn-get-id').addEventListener('click', onGetById);
}

async function onGet(){
  try {
      const response = await fetchGet(`${BASE_URL}/posts`);
      displayData(response);
  } catch(error) {
      console.error('error ', error);
  }
}

async function onGetById(){

  const id = document.getElementById('id-input').value;
  
  try {
    const response = await fetchGet(`${BASE_URL}/posts/${id}`);
    displayData(response);
  } catch(error) {
    console.error('error ', error);
  }
}

function removeChildLiElements(){

  const parentEl = document.getElementById('returned-data-ul');

  while( parentEl.firstChild ){
      parentEl.removeChild( parentEl.firstChild );
  }

  return parentEl;
}

function displayData(data){

  const ulEl = removeChildLiElements();
  
  addLiObject(ulEl, `status code: ${data.statusCode}`);
  addLiObject(ulEl, `status desc: ${data.statusDescription}`);
  
  if( Array.isArray(data.body) ){
    data.body.forEach( eachData => addLiObject(ulEl, eachData) );
  } else {
    addLiObject(ulEl, data.body);
  }
} 

function addLiObject(parent, eachData){
  const eachLiEl = document.createElement('li');
  eachLiEl.innerText = typeof eachData === 'object' 
    ? getObjStr(eachData)
    : eachData
  parent.insertAdjacentElement('beforeend', eachLiEl);
}

function getObjStr(object){

  const objStr = [];

  for(let key in object){
    objStr.push(`${key}: ${object[key]}`);
  }

  return objStr.join('\n');
}

async function fetchGet(endpoint, bearerToken){

  const headers = bearerToken
    ? { 'Authorization': `Bearer ${bearerToken}` }
    : null;

  return await genericFetch(endpoint, 'GET', headers);
}

async function genericFetch(endpointUrl, method, headers, body){

  if(!endpointUrl || !method){
    console.error(`endpointUrl (${endpointUrl}) or method (${method}) not defined`);
    return false;
  }

  const options = { method };

  if(headers){
    options.headers = headers;
  }

  if(body){
    options.body = body;
  }

  try {
    const response = await fetch(endpointUrl, options);

    const contentLength = response.headers.get('Content-Length');
    const contentType = response.headers.get('Content-Type');

    // Only factor in length OR header if they're present
    const isValidBodyLength = contentLength ? contentLength > 0 : false;
    const isValidBodyContentType = contentType?.includes('application/json') ?? false;
    const isJsonBodyAvailable = isValidBodyLength || isValidBodyContentType;

    const responseBody = isJsonBodyAvailable && !response.bodyUsed
        ? await response.json()
        : null;

    return {
      statusCode: response.status,
      statusDescription: response.statusText,
      body: responseBody
    };
  } catch(error){
    console.error('error ', error)
  }
}
//---------------------------------------- RAWG --------------------------------------------
const BASE_URL_RAWG = ''; // localhost something instead

function addRAWGListeners() {
  document.getElementById('btn-get-games').addEventListener('click', onGetById);
}

async function onGetById(){

  const id = document.getElementById('id-input').value;
  
  try {
    const response = await fetchGet(`${BASE_URL}/posts/${id}`);
    displayData(response);
  } catch(error) {
    console.error('error ', error);
  }
}

function removeChildLiElements(){

  const parentEl = document.getElementById('returned-game-data-ul');

  while( parentEl.firstChild ){
    parentEl.removeChild( parentEl.firstChild );
  }

  return parentEl;
}

function displayData(data){

  const ulEl = removeChildLiElements();
  
  addLiObject(ulEl, `status code: ${data.statusCode}`);
  addLiObject(ulEl, `status desc: ${data.statusDescription}`);
  
  if( Array.isArray(data.body) ){
    data.body.forEach( eachData => addLiObject(ulEl, eachData) );
  } else {
    addLiObject(ulEl, data.body);
  }
} 

function addLiObject(parent, eachData){
  const eachLiEl = document.createElement('li');
  eachLiEl.innerText = typeof eachData === 'object' 
    ? getObjStr(eachData)
    : eachData
  parent.insertAdjacentElement('beforeend', eachLiEl);
}

function getObjStr(object){

  const objStr = [];

  for(let key in object){
    objStr.push(`${key}: ${object[key]}`);
  }

  return objStr.join('\n');
}

async function fetchGet(endpoint, bearerToken){

  const headers = bearerToken
    ? { 'Authorization': `Bearer ${bearerToken}` }
    : null;

  return await genericFetch(endpoint, 'GET', headers);
}

async function genericFetch(endpointUrl, method, headers, body){

  if(!endpointUrl || !method){
    console.error(`endpointUrl (${endpointUrl}) or method (${method}) not defined`);
    return false;
  }

  const options = { method };

  if(headers){
    options.headers = headers;
  }

  if(body){
    options.body = body;
  }

  try {
    const response = await fetch(endpointUrl, options);

    const contentLength = response.headers.get('Content-Length');
    const contentType = response.headers.get('Content-Type');

    // Only factor in length OR header if they're present
    const isValidBodyLength = contentLength ? contentLength > 0 : false;
    const isValidBodyContentType = contentType?.includes('application/json') ?? false;
    const isJsonBodyAvailable = isValidBodyLength || isValidBodyContentType;

    const responseBody = isJsonBodyAvailable && !response.bodyUsed
        ? await response.json()
        : null;

    return {
      statusCode: response.status,
      statusDescription: response.statusText,
      body: responseBody
    };
  } catch(error){
    console.error('error ', error)
  }
}

 /* ------------------------------------  DOMCONTENT  ------------------------------------ */
document.addEventListener("DOMContentLoaded", () => {

  /* ----------------------  SCROLL TO TOP  ---------------------- */
  window.onscroll = function() {scrollFunction()};


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
  const loginModal = document.getElementById('login-modal');

  // When user clicks outside modal, it closes
  window.onclick = (event)=> {
    if (event.target == loginModal) {
        loginModal.style.display = "none";
    }
  }

  /* ----------------------  SHOW FAVORITE TOP PICKS  ---------------------- */
  const testButton = document.getElementById('test-button');

  testButton.addEventListener('click', () => {
    while (testArea.children.length > 0) {
      testArea.removeChild(testArea.lastElementChild);
    }
    
    gameFavorites.getGames().forEach(game => {
        createCard(game, testArea);
    });

  });

  /* ----------------------  CLEAR FAVORITES  ---------------------- */
  const clearResultsButton = document.getElementById('clear-results-button');
  clearResultsButton.addEventListener('click', () => {
    while (testArea.children.length > 0) {
      testArea.removeChild(testArea.lastElementChild);
    }
    alert("Game cards successfully removed!");
  });

  /* -------------------------------  SEARCH FAVORITES  ------------------------------- */
  // All objects displayed
  /* resultsEl = document.getElementById('results');
  resultsEl.innerText = JSON.stringify(gameFavorites.getGames()); */
  
  // Search button listener & handler
  const searchFavBtn = document.getElementById('search-favorites-button');

  searchFavBtn.addEventListener('click', () => {
    // Get what the user typed into the text field
    const textEntered = document.getElementById('search-input').value.toLowerCase();
    
    // API request to backend
    // fetch /GET `shoes?type=${inputStr}`\
    
    // Array filter based on user input
    const filteredGames = gameFavorites.getGames().filter( (game) => {
      return game.name.toLowerCase().includes(textEntered);
    });


    /*  const simplifiedGames = filteredGames.map(game => ({
      name: game.name,
      // description: game.description,
      platforms: game.platforms,
      genres: game.genres,
      developers: game.developers,
      release: game.release
    })); */

    // Clear previous search results
    while (testArea.firstChild) {
      testArea.removeChild(testArea.firstChild);
    }

    // Create and append gameCard for each filtered game
    filteredGames.forEach(game => {
        createCard(game, testArea);
    });
   

    // Display results
    // const resultsEl = document.getElementById('results')
    // resultsEl.innerText = JSON.stringify(filteredGames);
    // resultsEl.innerText = JSON.stringify(simplifiedGames);

  });


  /* ----------------------  FETCH DEMO  ---------------------- */
  addButtonListeners();


  /* ----------------------  BROWSE GAMES  ---------------------- */
  addRAWGListeners();
    

    
});

