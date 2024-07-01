let gameFavorites = {
  allGames: [
    {
      "gameId": 1,
      "name": "Chrono Trigger",
      "description": "Experience a non-linear game system, which allows players to change chronological game events to produce multiple ending scenarios for endless hours of gameplay. Revolutionary battle system that seamlessly integrates battles into gameplay and allows players to avoid most enemy encounters. Unique character abilities give players the option to perform visually impressive combination techniques, adding depth to battle strategies.",
      "platforms": "Mobile, Nintendo DS, PC, PlayStation, Super Nintendo",
      "genres": "Top-Down, Real-Time, Role-Playing",
      "developers": "SquarePublisher",
      "release": "August 22, 1995",
      "price": 14.99,
      "imageName": "https://ih1.redbubble.net/image.2228367445.8803/flat,750x,075,f-pad,750x1000,f8f8f8.jpg"
    },
    {
      "gameId": 2,
      "name": "The Legend of Zelda: Breath of the Wild",
      "description": "Forget everything you know about The Legend of Zelda games. Step into a world of discovery, exploration and adventure in The Legend of Zelda: Breath of the Wild, a boundary-breaking new game in the acclaimed series. Travel across fields, through forests and to mountain peaks as you discover what has become of the ruined kingdom of Hyrule in this stunning open-air adventure.",
      "platforms": "Nintendo Switch, Wii U",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Nintendo EPD",
      "release": "March 03, 2017",
      "price": 21.99,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/c/c6/The_Legend_of_Zelda_Breath_of_the_Wild.jpg"
    },
    {
      "gameId": 3,
      "name": "Teenage Mutant Ninja Turtles: Shredder's Revenge",
      "description": "Teenage Mutant Ninja Turtles: Shredder’s Revenge features groundbreaking gameplay rooted in timeless classic brawling mechanics, brought to you by the beat ’em up experts at Dotemu (Streets of Rage 4) and Tribute Games. Bash your way through gorgeous pixel art environments and slay tons of hellacious enemies with your favorite Turtle, each with his own skills and moves - making each run unique! Choose a fighter, use radical combos to defeat your opponents, and experience intense combats loaded with breathtaking action and outrageous ninja abilities. Stay sharp as you face off against Shredder and his faithful Foot Clan alone, or grab your best buds and play with up to 6 players simultaneously!",
      "platforms": "Mobile, Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One",
      "genres": "Beat em Up, Fighting",
      "developers": "Tribute Games",
      "release": "June 16, 2022",
      "price": 9.59,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/1/1e/Teenage_Mutant_Ninja_Turtles_Shredder%E2%80%99s_Revenge_cover_art.jpg/220px-Teenage_Mutant_Ninja_Turtles_Shredder%E2%80%99s_Revenge_cover_art.jpg"
    },
    {
      "gameId": 4,
      "name": "Helldivers 2",
      "description": "Time to take out the alien trash. Join the Helldivers to fight for freedom across a hostile galaxy in third-person shooter operations.",
      "platforms": "PC, Playstation 5",
      "genres": "Third-Person, Action, Shooter",
      "developers": "Arrowhead Game Studios",
      "release": "February 08, 2024",
      "price": 39.99,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/e/e7/Helldivers2cover.png"
    },
    {
      "gameId": 5,
      "name": "Animal Crossing: New Horizons",
      "description": "Nook Inc. invites you to create your personal island paradise on a deserted island brimming with possibility.",
      "platforms": "PC, Playstation 5",
      "genres": "Third-Person, Action, Shooter",
      "developers": "Arrowhead Game Studios",
      "release": "February 08, 2024",
      "price": 5.79,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/1/1f/Animal_Crossing_New_Horizons.jpg"
    },
    {
      "gameId": 6,
      "name": "Dragon's Crown",
      "description": "Brandish your blade, dust off your grimoire, and rally your online adventuring party. Dragon's Crown thrusts you into a fantastical medieval world packed with labyrinthine dungeons to explore, vile monstrosities to smite, and nearly endless online adventure. Your mission is to dive into the dank underworld, uncovering treasure and strengthening your mettle as you unlock the secret behind the ancient dragon threatening the world.",
      "platforms": "PlayStation 3, PlayStation 4, PlayStation Vita",
      "genres": "Action, Beat em Up, Role-Playing",
      "developers": "Vanillaware, Atlus",
      "release": "August 06, 2013",
      "price": 5.79,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/c/cd/Dragons_Crown.png/220px-Dragons_Crown.png"
    },
    {
      "gameId": 7,
      "name": "Marvel's Spider-Man",
      "description": "After eight years behind the mask, Peter Parker is a crime-fighting master. Feel the full power of a more experienced Spider-Man with improvisational combat, dynamic acrobatics, fluid urban traversal, and environmental interactions. A rookie no longer, this is the most masterful Spider-Man you’ve ever played.",
      "platforms": "PC, PlayStation 4",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Insomniac Games",
      "release": "September 07, 2018",
      "price": 5.79,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/e/e1/Spider-Man_PS4_cover.jpg"
    },
    {
      "gameId": 8,
      "name": "Fallout 4",
      "description": "As the sole survivor of Vault 111, you enter a world destroyed by nuclear war. Every second is a fight for survival, and every choice is yours. Only you can rebuild and determine the fate of the Wasteland. Welcome home.",
      "platforms": "PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "First-Person, Third-Person, Action, Open World, Role-Playing, Shooter",
      "developers": "Bethesda Game Studios",
      "release": "November 10, 2015",
      "price": 5.79,
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Fallout_4_cover_art.jpg/220px-Fallout_4_cover_art.jpg"
    },
    {
      "gameId": 9,
      "name": "Muramasa: The Demon Blade",
      "description": "The creators of the acclaimed PlayStation 2 hit, Odin Sphere, return with the single player, action RPG, Muramasa: The Demon Blade. Steeped in the ancient mythology of Japan, Muramasa: The Demon Blade tells a tale of possessed souls, forgotten pasts and unimaginable destinies.",
      "platforms": "PlayStation Vita, Wii, Wii U",
      "genres": "Action role-playing",
      "developers": "Vanillaware",
      "release": "September 08, 2009",
      "price": 5.79,
      "imageName": "https://howlongtobeat.com/games/250px-Muramasa_The_Demon_Blade.jpg"
    },
    {
      "gameId": 10,
      "name": "The Legend of Zelda: The Wind Waker",
      "description": "Nintendo's thematic action-adventure sequel to Ocarina of Time takes the series back to its more cartoonish roots. Utilizing a completely new look with cel-shaded graphics, the game casts players in the role of a familiar young boy, who sets out to save his kidnapped sister. Gameplay is vintage Zelda, only that the game's overworld is covered by water. Players have to control the direction of the wind to sail across the ocean and find dungeons, towns, and plenty of secrets. A special Game Boy Advance link-up option lets another player join the quest and give hints and assistance via the handheld.",
      "platforms": "Nintendo GameCube, Wii U",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Nintendo EAD",
      "release": "March 24, 2003",
      "price": 5.79,
      "imageName": "https://m.media-amazon.com/images/M/MV5BMzAxNzI3YjYtNTY1MC00MjJjLThkYmItYWYxZGJiYjIzMDQ5XkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_.jpg"
    }
    
  ],

   getGames() {
    return this.allGames;
  },


};
