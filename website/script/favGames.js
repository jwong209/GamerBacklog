let gameFavorites = {
  allGames: [
    {
      "id": 1,
      "name": "Chrono Trigger",
      "description": "Experience a non-linear game system, which allows players to change chronological game events to produce multiple ending scenarios for endless hours of gameplay. Revolutionary battle system that seamlessly integrates battles into gameplay and allows players to avoid most enemy encounters. Unique character abilities give players the option to perform visually impressive combination techniques, adding depth to battle strategies.",
      "platforms": "Mobile, Nintendo DS, PC, PlayStation, Super Nintendo",
      "genres": "Top-Down, Real-Time, Role-Playing",
      "developers": "SquarePublisher",
      "release": "August 22, 1995",
      "imageName": "https://ih1.redbubble.net/image.2228367445.8803/flat,750x,075,f-pad,750x1000,f8f8f8.jpg"
    },
    {
      "id": 2,
      "name": "The Legend of Zelda: Breath of the Wild",
      "description": "Forget everything you know about The Legend of Zelda games. Step into a world of discovery, exploration and adventure in The Legend of Zelda: Breath of the Wild, a boundary-breaking new game in the acclaimed series. Travel across fields, through forests and to mountain peaks as you discover what has become of the ruined kingdom of Hyrule in this stunning open-air adventure.",
      "platforms": "Nintendo Switch, Wii U",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Nintendo EPD",
      "release": "March 03, 2017",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/c/c6/The_Legend_of_Zelda_Breath_of_the_Wild.jpg"
    },
    {
      "id": 3,
      "name": "Teenage Mutant Ninja Turtles: Shredder's Revenge",
      "description": "Teenage Mutant Ninja Turtles: Shredder’s Revenge features groundbreaking gameplay rooted in timeless classic brawling mechanics, brought to you by the beat ’em up experts at Dotemu (Streets of Rage 4) and Tribute Games. Bash your way through gorgeous pixel art environments and slay tons of hellacious enemies with your favorite Turtle, each with his own skills and moves - making each run unique! Choose a fighter, use radical combos to defeat your opponents, and experience intense combats loaded with breathtaking action and outrageous ninja abilities. Stay sharp as you face off against Shredder and his faithful Foot Clan alone, or grab your best buds and play with up to 6 players simultaneously!",
      "platforms": "Mobile, Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One",
      "genres": "Beat em Up, Fighting",
      "developers": "Tribute Games",
      "release": "June 16, 2022",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/1/1e/Teenage_Mutant_Ninja_Turtles_Shredder%E2%80%99s_Revenge_cover_art.jpg/220px-Teenage_Mutant_Ninja_Turtles_Shredder%E2%80%99s_Revenge_cover_art.jpg"
    },
    {
      "id": 4,
      "name": "Helldivers 2",
      "description": "Time to take out the alien trash. Join the Helldivers to fight for freedom across a hostile galaxy in third-person shooter operations.",
      "platforms": "PC, Playstation 5",
      "genres": "Third-Person, Action, Shooter",
      "developers": "Arrowhead Game Studios",
      "release": "February 08, 2024",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/e/e7/Helldivers2cover.png"
    },
    {
      "id": 5,
      "name": "Animal Crossing: New Horizons",
      "description": "Nook Inc. invites you to create your personal island paradise on a deserted island brimming with possibility.",
      "platforms": "PC, Playstation 5",
      "genres": "Third-Person, Action, Shooter",
      "developers": "Arrowhead Game Studios",
      "release": "February 08, 2024",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/1/1f/Animal_Crossing_New_Horizons.jpg"
    },
    {
      "id": 6,
      "name": "Dragon's Crown",
      "description": "Brandish your blade, dust off your grimoire, and rally your online adventuring party. Dragon's Crown thrusts you into a fantastical medieval world packed with labyrinthine dungeons to explore, vile monstrosities to smite, and nearly endless online adventure. Your mission is to dive into the dank underworld, uncovering treasure and strengthening your mettle as you unlock the secret behind the ancient dragon threatening the world.",
      "platforms": "PlayStation 3, PlayStation 4, PlayStation Vita",
      "genres": "Action, Beat em Up, Role-Playing",
      "developers": "Vanillaware, Atlus",
      "release": "August 06, 2013",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/c/cd/Dragons_Crown.png/220px-Dragons_Crown.png"
    },
    {
      "id": 7,
      "name": "Marvel's Spider-Man",
      "description": "After eight years behind the mask, Peter Parker is a crime-fighting master. Feel the full power of a more experienced Spider-Man with improvisational combat, dynamic acrobatics, fluid urban traversal, and environmental interactions. A rookie no longer, this is the most masterful Spider-Man you’ve ever played.",
      "platforms": "PC, PlayStation 4",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Insomniac Games",
      "release": "September 07, 2018",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/e/e1/Spider-Man_PS4_cover.jpg"
    },
    {
      "id": 8,
      "name": "Fallout 4",
      "description": "As the sole survivor of Vault 111, you enter a world destroyed by nuclear war. Every second is a fight for survival, and every choice is yours. Only you can rebuild and determine the fate of the Wasteland. Welcome home.",
      "platforms": "PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "First-Person, Third-Person, Action, Open World, Role-Playing, Shooter",
      "developers": "Bethesda Game Studios",
      "release": "November 10, 2015",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Fallout_4_cover_art.jpg/220px-Fallout_4_cover_art.jpg"
    },
    {
      "id": 9,
      "name": "Muramasa: The Demon Blade",
      "description": "The creators of the acclaimed PlayStation 2 hit, Odin Sphere, return with the single player, action RPG, Muramasa: The Demon Blade. Steeped in the ancient mythology of Japan, Muramasa: The Demon Blade tells a tale of possessed souls, forgotten pasts and unimaginable destinies.",
      "platforms": "PlayStation Vita, Wii, Wii U",
      "genres": "Action role-playing",
      "developers": "Vanillaware",
      "release": "September 08, 2009",
      "imageName": "https://howlongtobeat.com/games/250px-Muramasa_The_Demon_Blade.jpg"
    },
    {
      "id": 10,
      "name": "Resident Evil 4 (2023)",
      "description": "Resident Evil 4 has reawakened for a new generation of terror fans, powered by RE Engine to deliver modernized gameplay, a reimagined storyline, and vividly detailed graphics while still preserving the essence of the 2005 original.",
      "platforms": "Mobile, PC, PlayStation 4, PlayStation 5, Xbox Series X/S",
      "genres": "Third-Person, Horror, Survival",
      "developers": "Capcom",
      "release": "March 24, 2023",
      "imageName": "https://howlongtobeat.com/games/108881_Resident_Evil_4.jpg?width=250"
    },
    {
      "id": 11,
      "name": "Super Mario 64",
      "description": "Nintendo's thematic action-adventure sequel to Ocarina of Time takes the series back to its more cartoonish roots. Utilizing a completely new look with cel-shaded graphics, the game casts players in the role of a familiar young boy, who sets out to save his kidnapped sister. Gameplay is vintage Zelda, only that the game's overworld is covered by water. Players have to control the direction of the wind to sail across the ocean and find dungeons, towns, and plenty of secrets. A special Game Boy Advance link-up option lets another player join the quest and give hints and assistance via the handheld.",
      "platforms": "Nintendo GameCube, Wii U",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Nintendo EAD",
      "release": "March 24, 2003",
      "imageName": "https://howlongtobeat.com/games/Super_Mario_64_box_cover.jpg"
    },
    {
      "id": 12,
      "name": "Star Fox 64",
      "description": "The Star Fox 64 is a scrolling shooter video game developed for Nintendo 64 gaming console. Defeat the enemy in the single player mode, or play this rail shooter video game in the multi-player mode for a combined attack. In this Nintendo 64 video game, the General Pepper sends the Star Fox team to investigate the unusual activity spotted on planet Venom. The evil scientist, Andross, on the planet captures James McCloud and Peppy Hare as Pigma betrays them. In this rail shooter video game, you play as Fox McCloud, the son of James McCloud, who along with Falco Lombardi, Peppy Hare, and Slippy Toad investigates Andross' attack across the Lylat star system. As Fox McCloud, you need to battle Andross' armies and the team's mercenaries, Star Wolf in this Nintendo 64 video game. Control Fox's Arwing, dodge obstacles and advance your way towards victory in the Star Fox 64 game. Approach Andross from deep-space Area 6, kill him, and you gain credit points. The medals gained let you unlock Landmaster tank with upgraded lasers for the multiplayer mode.",
      "platforms": "Nintendo 64",
      "genres": "On-Rails, Shooter",
      "developers": "Nintendo EAD",
      "release": "June 30, 1997",
      "imageName": "https://howlongtobeat.com/games/250px-StarFox64_N64_Game_Box.jpg"
    },
    {
      "id": 13,
      "name": "Final Fantasy VII Remake",
      "description": "What begins as a rebellion against an evil corporation becomes much more, and what erupts goes beyond imagination. The story of this first, standalone game in the Final Fantasy VII Remake project covers up to the party's escape from Midgar and goes deeper into the events occurring in the city than the original Final Fantasy VII.",
      "platforms": "PC, PlayStation 4, PlayStation 5",
      "genres": "Third-Person, Action, Adventure, Role-Playing",
      "developers": "Square Enix",
      "release": "April 10, 2020",
      "imageName": "https://howlongtobeat.com/games/57686_Final_Fantasy_VII_Remake.jpg"
    },
    {
      "id": 14,
      "name": "Star Wars: Battlefront II (2017)",
      "description": "Fight more of the greatest Star Wars Battles any way you want. Fight on the front lines where every weapon and vehicle is yours. Now for the first time, Star Wars: Battlefront II lets you Fight as a Jedi, Battle in Space, and Play 13 new Locations. Defeat enemy ships and destroy the heavy cruisers and capital ships to achieve victory, or land within enemy territory and blow up a Star Destroyer from the inside.",
      "platforms": "PC, PlayStation 4, Xbox One",
      "genres": "First-Person, Shooter",
      "developers": "EA DICE",
      "release": "November 17, 2017",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/2/23/SWBF2_box.jpeg"
    },
    {
      "id": 15,
      "name": "Batman: Arkham City",
      "description": "Batman: Arkham City builds upon the intense, atmospheric foundation of Batman: Arkham Asylum, sending players soaring into Arkham City, the new maximum security home for all of Gotham City's thugs, gangsters and insane criminal masterminds. Set inside the heavily fortified walls of a sprawling district in the heart of Gotham City, this highly anticipated sequel introduces a brand-new story that draws together a new all-star cast of classic characters and murderous villains from the Batman universe, as well as a vast range of new and enhanced gameplay features to deliver the ultimate experience as the Dark Knight.",
      "platforms": "OnLive, PC, PlayStation 3, Wii U, Xbox 360",
      "genres": "Action, Adventure, Beat em Up",
      "developers": "Rocksteady Studios",
      "release": "October 18, 2011",
      "imageName": "https://howlongtobeat.com/games/882_Batman_Arkham_City.jpg?width=250"
    },
    {
      "id": 16,
      "name": "The Legend of Zelda: The Wind Waker",
      "description": "Nintendo's thematic action-adventure sequel to Ocarina of Time takes the series back to its more cartoonish roots. Utilizing a completely new look with cel-shaded graphics, the game casts players in the role of a familiar young boy, who sets out to save his kidnapped sister. Gameplay is vintage Zelda, only that the game's overworld is covered by water. Players have to control the direction of the wind to sail across the ocean and find dungeons, towns, and plenty of secrets. A special Game Boy Advance link-up option lets another player join the quest and give hints and assistance via the handheld.",
      "platforms": "Nintendo GameCube, Wii U",
      "genres": "Third-Person, Action, Adventure, Open World",
      "developers": "Nintendo EAD",
      "release": "March 24, 2003",
      "imageName": "https://m.media-amazon.com/images/M/MV5BMzAxNzI3YjYtNTY1MC00MjJjLThkYmItYWYxZGJiYjIzMDQ5XkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_.jpg"
    },
    {
      "id": 17,
      "name": "Grand Theft Auto V",
      "description": "Developed by series creator Rockstar North, Grand Theft Auto V is the largest and most ambitious title in the series to date. Set in the sprawling city of Los Santos and the surrounding area, Grand Theft Auto V delivers a world of unprecedented scale and detail bursting with life, from mountaintops to the depths of the ocean.",
      "platforms": "PC, PlayStation 3, PlayStation 4, PlayStation 5, Xbox 360, Xbox One, Xbox Series X/S",
      "genres": "First-Person, Third-Person, Action, Open World, Racing/Driving, Shooter",
      "developers": "Rockstar North",
      "release": "September 17, 2013",
      "imageName": "https://howlongtobeat.com/games/4064_Grand_Theft_Auto_V.jpg?width=250"
    },
    {
      "id": 18,
      "name": "Final Fantasy VI",
      "description": "The War of Magi left little but ashes and misery in its wake. Even magic itself had vanished from the world. Now, a thousand years later, humankind has remade the world through the power of iron, gunpowder, steam engines, and other machines and technologies. But there is one who possesses the lost power of magic--a young girl name Terra whom the evil Empire has kept enslaved in an effort to harness her power as weapon. This leads to a fateful meeting between Terra and a young man named Locke. Their harrowing escape from the Empire's clutches sets in motion a series of events that touches countless lives and leads to one inevitable conclusion.",
      "platforms": "Game Boy Advance, Mobile, Nintendo Switch, PC, PlayStation, PlayStation 4, Super Nintendo",
      "genres": "Turn-Based, Role-Playing",
      "developers": "Square",
      "release": "October 11, 1994",
      "imageName": "https://howlongtobeat.com/games/3519_Final_Fantasy_VI.jpg?width=250"
    },
    {
      "id": 19,
      "name": "Super Mario RPG: Legend of the Seven Stars",
      "description": "Mario stars in his first RPG in this highly acclaimed role-playing adventure. Excellent 3-D graphics and a rich variety of game play will enthrall Mario and RPG fans alike! In Super Mario RPG, Mario's beloved Mushroom Kingdom has been thrown into chaos by the appearance of an extraterrestrial villain. This evil and outer space menace, Smithy, brings fear and treachery to the once-pleasant Mushroom Kingdom. Once Smithy crashes into the Star Road, he causes seven stars to be scattered throughout the land. Mario and his friends must recover the Seven Stars and repair the Star Road by making an epic journey to Bowser's castle to confront the dreaded Smithy. Princess Toadstool, Mallow, Geno, and--believe it or not!--Bowser help Mario restore tranquility and happiness to the Mushroom Kingdom. Powerful weapons, sinister spells and other items help Mario complete his harrowing journey. Conflicts take place in animated battle screens. After you choose battle options, the game carries out your fighting commands and spells. There are seven stages and 29 areas to navigate in Super Mario RPG. Integrating a traditional menu-driven RPG with action and puzzles, this pak offers a medley of playing excitement. The stunning graphics include fully rendered characters and gorgeous landscapes. For fans of Mario and role-playing games alike, Super Mario RPG shouldn't be missed.",
      "platforms": "Super Nintendo",
      "genres": "Isometric, Turn-Based, Platform, Role-Playing",
      "developers": "Square",
      "release": "May 13, 1996",
      "imageName": "https://howlongtobeat.com/games/256px-SuperMarioRPGSNESCoverArtUS.jpg?width=250"
    },
    {
      "id": 20,
      "name": "Super Mario RPG (2023)",
      "description": "Mario, Bowser, and Peach partner up to repair the wish-granting Star Road in this approachable role-playing adventure.",
      "platforms": "Nintendo Switch",
      "genres": "Isometric, Turn-Based, Role-Playing",
      "developers": "ArtePiazza",
      "release": "November 17, 2023",
      "imageName": "https://howlongtobeat.com/games/130456_Super_Mario_RPG.png?width=250"
    },
    {
      "id": 21,
      "name": "Streets of Rage 4",
      "description": "Streets of Rage is a beat ‘em up series known for its timeless gameplay and electronic dance-influenced music. Streets of Rage 4 builds upon the classic trilogy’s gameplay with new mechanics, beautiful hand-drawn visuals, and a God-tier soundtrack. With lush hand-drawn animations, new combat abilities, and fresh tracks from an amazing team of composers, Streets of Rage 4 will be a masterful tribute to and revitalization of the classic action fans adore.",
      "platforms": "Google Stadia, Mobile, Nintendo Switch, PC, PlayStation 4, Xbox One",
      "genres": "Beat em Up",
      "developers": "Lizardcube, Guard Crush Games, Dotemu",
      "release": "April 30, 2020",
      "imageName": "https://howlongtobeat.com/games/76482_Streets_of_Rage_4.jpg?width=250"
    },
    {
      "id": 22,
      "name": "Mario Kart 64",
      "description": "Though the single-player mode is a bit of a step back from the SNES original, Mario Kart 64 still offers one of the best multiplayer experiences to be had on Nintendo 64. Like its predecessor, the title is once again a kart race featuring classic Nintendo mascots. This time around players can race as everybody from Mario himself to Luigi, Bowser, the Princess, Yoshi, Donkey Kong and Wario. Mario Kart 64 features a good selection of straightforward single-player levels that allow players to sabotage computer controlled opponents on the roadside with various power-up bonuses. But the main attraction is the addictive multiplayer mode in which up to four players can battle against each other through several arena-style environments.",
      "platforms": "Nintendo 64",
      "genres": "Racing/Driving",
      "developers": "Nintendo EAD",
      "release": "February 10, 1997",
      "imageName": "https://howlongtobeat.com/games/250px-Mario_Kart_64box.png?width=250"
    },
    {
      "id": 23,
      "name": "Final Fantasy X",
      "description": "Final Fantasy X takes you into the world of Zanarkand, where you must face down the dark force called Sin to save the world. Tidus is a star athlete who survives a massive disaster. With the help of a girl named Yuna, he journeys to temples & monasteries to find truth. Learn to summon aeons-old spirits of power to add to your fighting abilities as you battle the evils of Sin. Spectacular graphics and incredible voiceover work will immerse you in a new world where evil forces threaten the existence of all you know!",
      "platforms": "Nintendo Switch, PC, PlayStation 2, PlayStation 3, PlayStation 4, PlayStation Vita, Xbox One",
      "genres": "Role-Playing",
      "developers": "Square",
      "release": "December 20, 2001",
      "imageName": "https://howlongtobeat.com/games/Ffxboxart.jpg?width=250"
    },
    {
      "id": 24,
      "name": "Mario Kart 8 Deluxe",
      "description": "Hit the road with the definitive version of Mario Kart 8 and play anytime, anywhere! Race your friends or battle them in a revised battle mode on new and returning battle courses. Play locally in up to 4-player multiplayer in 1080p while playing in TV Mode. Every track from the Wii U version, including DLC, makes a glorious return. Plus, the Inklings appear as all-new guest characters, along with returning favorites, such as King Boo, Dry Bones, and Bowser Jr.!",
      "platforms": "Nintendo Switch",
      "genres": "Racing/Driving",
      "developers": "Nintendo",
      "release": "April 28, 2017",
      "imageName": "https://howlongtobeat.com/games/43480_Mario_Kart_8_Deluxe.jpg?width=250"
    },
    {
      "id": 25,
      "name": "Metal Gear Solid V: The Phantom Pain",
      "description": "In the aftermath of the events of Ground Zeroes, Snake falls into a coma after the destruction of Mother Base, MSF's base of operations. Nine years later, Snake awakes from his coma and forms a new mercenary group, the Diamond Dogs.",
      "platforms": "PC, PlayStation 3, PlayStation 4, Xbox 360, Xbox One",
      "genres": "Third-Person, Action, Open World, Stealth",
      "developers": "Kojima Productions",
      "release": "September 01, 2015",
      "imageName": "https://howlongtobeat.com/games/MetalGearSolid5_2013.jpg?width=250"
    },
    {
      "id": 26,
      "name": "Super Mario Bros. Wonder",
      "description": "Mario and friends have been invited to visit the colorful Flower Kingdom, just a short hop away from the Mushroom Kingdom. Unfortunately, King Bowser has transformed into a flying castle and is causing chaos across their peaceful land. Now our heroes must save the day and the Flower Kingdom in this wondrous new adventure!",
      "platforms": "Nintendo Switch",
      "genres": "Side, Scrolling, Platform",
      "developers": "Nintendo EPD",
      "release": "October 20, 2023",
      "imageName": "https://howlongtobeat.com/games/130444_Super_Mario_Bros_Wonder.jpg?width=250"
    },
    {
      "id": 27,
      "name": "Onimusha: Warlords",
      "description": "In Onimusha: Warlords you follow the young samurai Samanosuke as he explores Inabayama Castle searching for Princess Yuki. Onimusha is a action-adventure game created by Mega Man creator, Keiji Inafune, and released for the PlayStation 2 in 2001. The play style is in the same vein as the older Resident Evil games. It was intended for the PlayStation but brought over to PlayStation 2, then later on for the Xbox under the title Genma Onimusha. It was also the first PlayStation 2 game to sell over a million copies.",
      "platforms": "Nintendo Switch, PC, PlayStation 2, PlayStation 4, Xbox, Xbox One",
      "genres": "Action, Adventure",
      "developers": "Capcom",
      "release": "March 13, 2001",
      "imageName": "https://howlongtobeat.com/games/250px-Onimusha_-_Warlords_Coverart.png?width=250"
    },
    {
      "id": 28,
      "name": "Super Mario Bros. 3",
      "description": "One of the most respected games in Nintendo's Mario Bros. series, Super Mario Bros. 3 introduced new moves and abilities to the tried-and-true sidescrolling platformer franchise. After the vastly different gameplay of Super Mario Bros. 2 (US), the third game in the series returns to form in glorious new ways with exciting added abilities like flying via the raccoon suit and hammer throwing with the Hammer Bros. suit. The idea is once again to thwart Bowser's evil plans and battle your way across eight different themed worlds to win a kiss from the Princess.",
      "platforms": "NES, Super Nintendo",
      "genres": "Side, Scrolling, Platform",
      "developers": "Nintendo EAD",
      "release": "February 12, 1990",
      "imageName": "https://howlongtobeat.com/games/250px-Super_Mario_Bros._3_coverart.png?width=250"
    },
    {
      "id": 29,
      "name": "Starcraft",
      "description": "Real-time strategy goes to new levels as three intergalactic species fight for survival. Control the vagabond Terrans, enigmatic Protoss, or the bloodthirsty Zerg as they wage war on the edge of the galaxy. Includes support for Internet play over Battle.net, Blizzard's on-line gaming service.",
      "platforms": "PC",
      "genres": "Real-Time, Strategy/Tactical",
      "developers": "Blizzard Entertainment, Mass Media Interactive Entertainment (N64)",
      "release": "March 31, 1998",
      "imageName": "https://howlongtobeat.com/games/250px-StarCraft_box_art.jpg?width=250"
    },
    {
      "id": 30,
      "name": "Monster Hunter: World",
      "description": "Welcome to a new world! Take on the role of a hunter and slay ferocious monsters in a living, breathing ecosystem where you can use the landscape and its diverse inhabitants to get the upper hand. Hunt alone or in co-op with up to three other players, and use materials collected from fallen foes to craft new gear and take on even bigger, badder beasts!",
      "platforms": "PC, PlayStation 4, Xbox One",
      "genres": "Action, Role-Playing",
      "developers": "Capcom",
      "release": "January 26, 2018",
      "imageName": "https://howlongtobeat.com/games/52493_Monster_Hunter_World.jpg?width=250"
    },
    {
      "id": 31,
      "name": "The Legend of Zelda: A Link to the Past",
      "description": "In all his glory Link ventures back to the land of Hyrule. The predecessors of Link and Zelda face monsters on the march when a menacing magician takes over the kingdom. Only you can prevent his evil plot from shattering the peaceful Hyrule. In your quest you'll venture into twisting mazes dungeons palaces and shadowy forests. Test your mettle with mighty swords and magical weapons. Or heft a boulder and hurl it at your enemies. If the going gets tough dive into a river-you can swim to escape! Learn powerful spells locate magical artifacts and solve the mysteries of the evil magician and the hidden realm of Hyrule.",
      "platforms": "Game Boy Advance, Super Nintendo",
      "genres": "Top-Down, Action, Adventure, Open World",
      "developers": "Nintendo EAD",
      "release": "April 13, 1992",
      "imageName": "https://howlongtobeat.com/games/250px-Zelda_SNES.jpg?width=250"
    },
    {
      "id": 32,
      "name": "Monster Hunter Rise",
      "description": "Set in the ninja-inspired land of Kamura Village, explore lush ecosystems and battle fearsome monsters to become the ultimate hunter. It’s been half a century since the last calamity struck, but a terrifying new monster has reared its head and threatens to plunge the land into chaos once again. Hunt solo or in a party with friends to earn rewards that you can use to craft a huge variety of weapons and armor. Brand new gameplay systems such as the high-flying ‘Wire Action’ and your canine companion ‘Palamute’ will add exciting new layers to the already robust combat that Monster Hunter is known for.",
      "platforms": "Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Third-Person, Action, Role-Playing",
      "developers": "Capcom",
      "release": "March 26, 2021",
      "imageName": "https://howlongtobeat.com/games/83169_Monster_Hunter_Rise.jpg?width=250"
    },
    {
      "id": 33,
      "name": "The Legend of Zelda",
      "description": "Ganon, the King of Evil, broke free from the Dark World and captured Hyrule's beloved Princess Zelda. Before she was caught, Zelda managed to shatter the Triforce of Wisdom and scatter its eight pieces throughout Hyrule. Link swore to recover the Triforce pieces and rescue Princess Zelda from Ganon's clutches.",
      "platforms": "Game & Watch, Game Boy Advance, NES",
      "genres": "Top-Down, Action, Adventure, Open World",
      "developers": "Nintendo EAD",
      "release": "August 22, 1987",
      "imageName": "https://upload.wikimedia.org/wikipedia/en/4/41/Legend_of_zelda_cover_%28with_cartridge%29_gold.png"
    },
    {
      "id": 34,
      "name": "Halo: Reach",
      "description": "Halo: Reach tells the tragic and heroic story of Noble Team, a group of Spartans, who through great sacrifice and courage saved countless lives in the face of impossible odds. The planet Reach is humanity's last line of defense between the encroaching Covenant and their ultimate goal, the destruction of Earth. If it falls, humanity will be perched on the brink of destruction.",
      "platforms": "PC, Xbox 360, Xbox One",
      "genres": "First-Person, Action, Shooter",
      "developers": "Bungie",
      "release": "September 14, 2010",
      "imageName": "https://howlongtobeat.com/games/Halo-_Reach_box_art.png?width=250"
    },
    {
      "id": 35,
      "name": "Gears of War 3",
      "description": "In Gears of War 3, players fight on as Marcus Fenix, the grizzled war hero and leader of Delta Squad. Eighteen months after the fall of the last human city, the war against the Locust rages on. Meanwhile, deep beneath the surface, a fearsome new threat is infecting the planet from within. With survivors scattered and civilization in ruins, time is running out for Marcus and his comrades as they fight to save the human race.",
      "platforms": "Xbox 360",
      "genres": "Third-Person, Action, Shooter",
      "developers": "Epic Games",
      "release": "September 20, 2011",
      "imageName": "https://howlongtobeat.com/games/250px-Gears_of_War_3_box_artwork.png?width=250"
    },
    {
      "id": 36,
      "name": "Dota 2",
      "description": "Dota began as a user-made modification for Warcraft 3 and has grown into one of the most played online games in the world. Following in the tradition of Counter-Strike, Day of Defeat, Team Fortress, Portal, and Alien Swarm, Dota 2 is the result of Valve hiring the community developers who built the mod and giving them the chance to finally build a full product out of their idea with the help of a professional team of developers and artists at Valve.",
      "platforms": "Linux, Mac, PC",
      "genres": "Massively Multiplayer, Action, Battle Arena",
      "developers": "Valve Corporation",
      "release": "July 09, 2013",
      "imageName": "https://howlongtobeat.com/games/250px-DotA2.jpg?width=250"
    },
    {
      "id": 37,
      "name": "Teenage Mutant Ninja Turtles: The Cowabunga Collection",
      "description": "Teenage Mutant Ninja Turtles: The Cowabunga Collection assembles thirteen classic TMNT games by Konami in one incredible package.",
      "platforms": "Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Action, Beat em Up",
      "developers": "Digital Eclipse",
      "release": "August 30, 2022",
      "imageName": "https://howlongtobeat.com/games/107321_Teenage_Mutant_Ninja_Turtles_The_Cowabunga_Collection.jpg?width=250"
    },
    {
      "id": 38,
      "name": "Gunstar Heroes",
      "description": "The Gunstar family are the protectors of the planet Gunstar 9. After many years of peace, vicious dictator Colonel Red kidnapped the Gunstar twins’ older brother and used mind control to make him his slave.",
      "platforms": "Nintendo 3DS, Nintendo Switch, PC, PlayStation 3, PlayStation 4, Sega Game Gear, Sega Mega Drive/Genesis, Wii, Xbox 360",
      "genres": "Side, Scrolling, Action, Platform, Shooter",
      "developers": "Treasure, M2",
      "release": "September 09, 1993",
      "imageName": "https://howlongtobeat.com/games/250px-Gunstar_Heroes.jpg?width=250"
    },
    {
      "id": 39,
      "name": "Sonic the Hedgehog 3 & Knuckles",
      "description": "Sonic 3 & Knuckles features several additions to the games not available otherwise, such as small alterations to the levels, and being able to play through Sonic 3 levels as Knuckles, or Sonic & Knuckles levels as Tails, and the ability to save progress in all of the game's levels. Additionally, this was the only way to collect Super Emeralds, which are earned by accessing Special Stages in the Sonic & Knuckles levels after collecting all seven Chaos Emeralds from Sonic 3. When all Super Emeralds have been collected, Sonic, Knuckles and Tails can transform into Hyper Sonic, Hyper Knuckles and Super Tails respectively, each with unique abilities.",
      "platforms": "PC, Sega Mega Drive/Genesis",
      "genres": "Platform",
      "developers": "Sonic Team, Sega Technical Institute",
      "release": "October 17, 1994",
      "imageName": "https://howlongtobeat.com/games/8743_Sonic_the_Hedgehog_3_&_Knuckles.jpg?width=250"
    },
    {
      "id": 40,
      "name": "Elite Beat Agents",
      "description": "The follow-up to the incredibly addictive Japanese music game, Osu! Tatakae! Ouendan. This is the first game of the series to come to America. The public knows of government agencies like the FBI and CIA, but little is known of this super-secret agency. Code-named Elite Beat Agents, these men in black are heroes' heroes and the coolest group of guys this world has ever known. Of course, according to official records, they do not exist. Their leader, an ex-CIA agent named Commander Kahn, scans the world for cries of help. When he finds one, he dispatches the agents, who assist their targets by performing a song and dance. The hypnotic nature of their rocking revives the targets with Groovy energy that boosts their willpower and helps them overcome their obstacles. In each stage, the agents arrive in a special Beat Transport and must tap and trace patterns that appear on-screen to the beat of the music to save the day.",
      "platforms": "Nintendo 3DS, Nintendo DS",
      "genres": "Music/Rhythm",
      "developers": "iNiS",
      "release": "November 06, 2006",
      "imageName": "https://howlongtobeat.com/games/Elite_Beat_Agents.jpg?width=250"
    },
    {
      "id": 41,
      "name": "Persona 5 Royal",
      "description": "Persona 5 Royal is a remake of the original Persona 5 with the addition of many new elements, including a new third semester, new events involving daily school life and the Phantom Thieves, new characters, locations, and more.",
      "platforms": "Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Third-Person, Turn-Based, Role-Playing, Simulation",
      "developers": "P-Studio",
      "release": "March 31, 2020",
      "imageName": "https://howlongtobeat.com/games/66630_Persona_5_Royal.jpg?width=250"
    },
    {
      "id": 42,
      "name": "Splatoon 3",
      "description": "Enter a sun-scorched desert inhabited by battle-hardened Inklings and Octolings. Ink, dive, swim, and splat your way to the top!",
      "platforms": "Nintendo Switch",
      "genres": "Third-Person, Shooter",
      "developers": "Nintendo EPD",
      "release": "September 09, 2022",
      "imageName": "https://howlongtobeat.com/games/88768_Splatoon_3.jpg?width=250"
    },
    {
      "id": 43,
      "name": "Tetris Effect: Connected",
      "description": "Tetris Effect: Connected is the original Tetris Effect with all-new co-op and competitive online and local multiplayer modes. This is Tetris like you’ve never seen it, or heard it, or felt it before—an incredibly addictive, unique, and breathtakingly gorgeous reinvention of one of the most popular puzzle games of all time.",
      "platforms": "Nintendo Switch, Meta Quest, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Puzzle",
      "developers": "Monstars, Resonair, Stage Games",
      "release": "November 10, 2020",
      "imageName": "https://howlongtobeat.com/games/84923_Tetris_Effect_Connected.jpg?width=250"
    },
    {
      "id": 44,
      "name": "Star Wars Jedi: Survivor",
      "description": "Star Wars Jedi: Survivor picks up five years after the events of Star Wars Jedi: Fallen Order. Cal must stay one step ahead of the Empire’s constant pursuit as he continues to feel the weight of being one of the last remaining Jedi in the galaxy.",
      "platforms": "PC, PlayStation 5, Xbox Series X/S",
      "genres": "Action, Adventure, Open World",
      "developers": "Respawn Entertainment",
      "release": "April 28, 2023",
      "imageName": "https://howlongtobeat.com/games/108358_Star_Wars_Jedi_Survivor.jpg?width=250"
    },
    {
      "id": 45,
      "name": "Super Mario Odyssey",
      "description": "Mario embarks on a new journey through unknown worlds, running and jumping through huge 3D worlds in the first sandbox-style Mario game since Super Mario 64 and Super Mario Sunshine. Set sail between expansive worlds aboard an airship, and perform all-new actions, such as throwing Mario's cap.",
      "platforms": "Nintendo Switch",
      "genres": "Third-Person, Action, Platform",
      "developers": "Nintendo",
      "release": "October 27, 2017",
      "imageName": "https://howlongtobeat.com/games/42833_Super_Mario_Odyssey.jpg?width=250"
    },
    {
      "id": 46,
      "name": "Hades",
      "description": "Defy the god of death as you hack and slash your way out of the Underworld in this rogue-like dungeon crawler from the creators of Bastion and Transistor.",
      "platforms": "Mac, Mobile, Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Action, Roguelike, Role-Playing",
      "developers": "Supergiant Games",
      "release": "September 17, 2020",
      "imageName": "https://howlongtobeat.com/games/62941_Hades.jpg?width=250"
    },
    {
      "id": 47,
      "name": "Warcraft III: Reign of Chaos",
      "description": "It has been nearly 15 years since the war between the orcs and humans ended. An uneasy peace settled over the land while, for years, the drums of war were silent. Yet the kingdoms of men grew complacent in their victory--and slowly, the defeated orcish clans regrouped under the banner of a new visionary leader.<br><br>Now a darker shadow has fallen over the world, threatening to extinguish all life--all hope. The drums of war play upon the winds once again--rising urgently toward the inevitable hour when the skies will rain fire--and the world will tremble before the coming of the Burning Legion.<br><br>WarCraft III returns players to the war-torn world of Azeroth. Developer Blizzard Entertainment combines the lessons learned from its bestselling StarCraft, the famous WarCraft lineage, and all-new 3-D technology to create an all-new, vibrant strategy game sure to become a classic.<br><br>Wage war in a fully interactive 3-D world that incorporates nonplayer characters, wandering monsters, neutral towns, strongholds, temples, and environmental effects. Four mighty playable races--humans, orcs, night elves, and undead--compete in a finely balanced dance of conquest. Upgradable heroes gain experience and harness new powers as the game progresses. This is WarCraft that's intimately familiar, yet as you've never seen it before.",
      "platforms": "PC",
      "genres": "Real-Time, Strategy/Tactical",
      "developers": "Blizzard Entertainment",
      "release": "July 03, 2002",
      "imageName": "https://howlongtobeat.com/games/250px-WarcraftIII.jpg?width=250"
    },
    {
      "id": 48,
      "name": "Cyberpunk 2077",
      "description": "Cyberpunk 2077 is an open-world, action-adventure story set in Night City, a megalopolis obsessed with power, glamour and body modification. You play as V, a mercenary outlaw going after a one-of-a-kind implant that is the key to immortality.",
      "platforms": "Google Stadia, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "First-Person, Action, Role-Playing, Shooter",
      "developers": "CD Projekt RED",
      "release": "December 10, 2020",
      "imageName": "https://howlongtobeat.com/games/Cyberpunk-2077-2.jpg?width=250"
    },
    {
      "id": 49,
      "name": "Dark Souls III",
      "description": "As fires fade and the world falls into ruin, journey into a universe filled with more colossal enemies and environments. Players will be immersed into a world of epic atmosphere and darkness through faster gameplay and amplified combat intensity. Fans and newcomers alike will get lost in the game hallmark rewarding gameplay and immersive graphics. Now only embers remain. Prepare yourself once more and Embrace The Darkness!",
      "platforms": "PC, PlayStation 4, Xbox One",
      "genres": "Action, Role-Playing",
      "developers": "From Software",
      "release": "April 11, 2016",
      "imageName": "https://howlongtobeat.com/games/Dark_souls_3_cover_art.jpg?width=250"
    },
    {
      "id": 50,
      "name": "God of War (2018)",
      "description": "His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.",
      "platforms": "PC, PlayStation 4",
      "genres": "Third-Person, Action, Adventure, Hack and Slash",
      "developers": "SIE Santa Monica Studio",
      "release": "April 20, 2018",
      "imageName": "https://howlongtobeat.com/games/38050_God_of_War.jpg?width=250"
    },
    {
      "id": 51,
      "name": "Ninja Gaiden 3: Razor's Edge",
      "description": "Ninja Gaiden 3 offers for the first time a look at the world through Hayabusa's eyes, showing what drives him to fight, and kill. At the center of the conflict this time around is a masked man whose motivations and goals are unclear. Through mysterious powers, he changes Hayabusa - and the lines between hero and villain, good and evil, are blurred forever.",
      "platforms": "Nintendo Switch, PC, PlayStation 3, PlayStation 4, Wii U, Xbox 360, Xbox One",
      "genres": "Action, Adventure, Hack and Slash",
      "developers": "Team Ninja",
      "release": "November 18, 2012",
      "imageName": "https://howlongtobeat.com/games/6623_Ninja_Gaiden_3_Razors_Edge.jpg?width=250"
    },
    {
      "id": 52,
      "name": "Mystical Ninja Starring Goemon",
      "description": "As Goemon and his friends, explore ancient towns, haunted castles, and mysterious bamboo groves in polygonal 3D and solve puzzles to advance.",
      "platforms": "Nintendo 64",
      "genres": "Action, Adventure",
      "developers": "Konami Computer Entertainment Osaka",
      "release": "April 16, 1998",
      "imageName": "https://howlongtobeat.com/games/250px-MysticalNinjaStarringGoemon.jpg?width=250"
    },
    {
      "id": 53,
      "name": "Dragon Ball Z: Kakarot",
      "description": "Relive the story of Goku in DRAGON BALL Z: KAKAROT! Beyond the epic battles, experience life in the DRAGON BALL Z world as you fight, fish, eat, and train with Goku. Explore the new areas and adventures as you advance through the story and form powerful bonds with other heroes from the DRAGON BALL Z universe.",
      "platforms": "Google Stadia, Nintendo Switch, PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S",
      "genres": "Action, Role-Playing",
      "developers": "CyberConnect2",
      "release": "January 17, 2020",
      "imageName": "https://howlongtobeat.com/games/68262_Dragon_Ball_Z_Kakarot.jpg?width=250"
    },
    {
      "id": 54,
      "name": "Dragon Quest XI: Echoes of an Elusive Age",
      "description": "DRAGON QUEST XI: Echoes of an Elusive Age follows the perilous journey of a hunted Hero who must uncover the mystery of his fate with the aid of a charismatic cast of supporting characters.",
      "platforms": "Nintendo 3DS, PC, PlayStation 4",
      "genres": "Third-Person, Turn-Based, Role-Playing",
      "developers": "Square Enix",
      "release": "September 04, 2018",
      "imageName": "https://howlongtobeat.com/games/39508_Dragon_Quest_XI_In_Search_of_Departed_Time.jpg?width=250"
    },
    {
      "id": 55,
      "name": "Mega Man X",
      "description": "Mega Man X is a robot designed by Dr. Light to choose his own path in life. Years after he is created, Dr. Cain finds X and mimics his design to create a race of such robots called reploids. When the sigma virus infects these reploids, causing them to commit acts of evil, it is up to Mega Man X and his partner Zero (who is quite powerful, contrary to what his name implies) to stop it.",
      "platforms": "Mobile, PC, Super Nintendo",
      "genres": "Side, Scrolling, Platform",
      "developers": "Capcom",
      "release": "January 19, 1994",
      "imageName": "https://howlongtobeat.com/games/Mega_Man_X_Coverart.png?width=250"
    },
    {
      "id": 56,
      "name": "LEGO Marvel Super Heroes",
      "description": "Lego Marvel Super Heroes features an original story crossing all the Marvel families. Players take control of Iron Man, Spider-Man, The Hulk, Captain America, Wolverine and many more Marvel characters as they try to stop Loki and a host of other Marvel villains from assembling a Super weapon which they could use to control the Earth. Players will chase down Comic Bricks as they travel across a LEGO New York and visit key locations from the Marvel universe such as Stark Tower, Asteroid M, an abandoned Hydra Base and the X-Mansion.",
      "platforms": "PC, Nintendo 3DS, Nintendo Switch, PlayStation 3, PlayStation 4, PlayStation Vita, Wii U, Xbox 360, Xbox One",
      "genres": "Action, Adventure",
      "developers": "TT Games",
      "release": "October 22, 2013",
      "imageName": "https://howlongtobeat.com/games/Lego-Marvel-cover.jpg?width=250"
    },
    {
      "id": 57,
      "name": "Mega Man X",
      "description": "Warcraft Rumble is a mobile action strategy game where collectible Warcraft Minis come to life to clash in epic melee battles. Whether you choose to play in the massive single player campaign or compete head-to-head in epic PvP battles, prepare to experience the true meaning of joyful chaos!",
      "platforms": "MobileGenre",
      "genres": "Strategy/Tactical",
      "developers": "Blizzard Entertainment",
      "release": "November 03, 2023",
      "imageName": "https://howlongtobeat.com/games/140231_Warcraft_Rumble.jpg?width=250"
    }
    
  ],

   getGames() {
    return this.allGames;
  },


};
