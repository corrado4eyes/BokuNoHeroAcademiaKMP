import Character from '../models/character.ts';
import { v4 } from "https://deno.land/std/uuid/mod.ts";

const characterList: Character[] = [
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/d/d9/Izuku_Midoriya_school_profile.png/revision/latest?cb=20190129015623",
        name: "Izuku Midoriya",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "One For All"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/8/83/Katsuki_Bakugo_School_Uniform_Full_Body.png/revision/latest?cb=20190812065435",
        name: "Bakugō Katsuki",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Explosion"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/6/66/Minoru_Mineta_Full_Body_School_Uniform_Anime.png/revision/latest?cb=20160118115800",
        name: "Minoru Mineta",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Pop Off"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/e/eb/Momo_Yaoyorozu_Full_Body_School_Uniform.png/revision/latest?cb=20161230174913",
        name: "Momo Yaoyorozu",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Creation"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/8/8f/Toru_Hagakure_Full_Body_Uniform.png/revision/latest?cb=20161230191807",
        name: "Toru Hagakure",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Invisibility"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/c/c4/Shoto_Todoroki_school_profile.png/revision/latest?cb=20170728153443",
        name: "Shoto Todoroki",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Half-Cold Half-Hot"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/b/ba/Fumikage_Tokoyami_Uniform.png/revision/latest?cb=20200519142933",
        name: "Fumikage Tokoyami",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Dark Shadow"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/6/6c/Hanta_Sero_Full_Body_Uniform.png/revision/latest?cb=20161230191259",
        name: "Hanta Sero",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Tape"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/8/8c/Kyoka_Jiro_Full_Body_Uniform.png/revision/latest?cb=20161230185934",
        name:  "Kyoka Jiro",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Earphone Jack"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/5/55/Mezo_Shoji_Full_Body_Uniform.png/revision/latest?cb=20161230190626",
        name:  "Mezo Shoji",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Dupli-Arms"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/c/c9/Rikido_Sato_Full_Body_Uniform.png/revision/latest?cb=20161230192002",
        name:  "Rikido Sato",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Sugar Rush"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/2/20/Koji_Koda_Full_Body_Uniform.png/revision/latest?cb=20161230192420",
        name:  "Koji Koda",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Anivoice"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/3/3a/Eijiro_Kirishima_Student_Uniform_Profile.png/revision/latest?cb=20190129175755",
        name:  "Eijiro Kirishima",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Hardening"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/b/bb/Denki_Kaminari.png/revision/latest?cb=20190129015706",
        name:  "Denki Kaminari",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Electrification"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/0/09/Mashirao_Ojiro_Full_Body_Uniform.png/revision/latest?cb=20161230191029",
        name:  "Mashirao Ojiro",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Tail"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/6/69/Ochaco_School_Uniform_Full_Body.png/revision/latest?cb=20190215054343",
        name:  "Ochaco Uraraka",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Zero Gravity"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/1/10/Tenya_Iida_Full_Body_School_Uniform.png/revision/latest?cb=20190129175925",
        name:  "Tenya Iida",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Engine"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/f/ff/Tsuyu_Asui_Full_Body_School_Uniform_Anime.png/revision/latest?cb=20160118114942",
        name:  "Tsuyu Asui",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Frog"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/4/4e/Mina_Ashido_Full_Body_School_Uniform.png/revision/latest?cb=20190129180054",
        name:  "Mina Ashido",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Acid"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/4/45/Yuga_Aoyama_full_body_uniform.png/revision/latest?cb=20161230185513",
        name:  "Yuga Aoyama",
        characterClass: "Class 1-A",
        category: "Students",
        quirk: "Navel Laser"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/3/32/All_For_One_Profile.png/revision/latest?cb=20180528014920",
        name: "All For One",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "All For One"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/0/00/Tomura_Shigaraki_Anime_Profile_2.png/revision/latest?cb=20191011223510",
        name: "Tomura Shigaraki",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Decay"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/2/23/Kurogiri_Anime_Profile.png/revision/latest?cb=20170805212000",
        name: "Kurogiri",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Warp Gate"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/a/a6/Gigantomachia_first_appearance_%28Anime%29.png/revision/latest?cb=20200128013439",
        name: "Gigantomachia",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Unknown Quirk"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/5/56/Kyudai_Garaki_Portrait.png/revision/latest?cb=20190604180049",
        name: "Kyudai Garaki",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Life force"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/5/5a/Giran_art.png/revision/latest?cb=20191005160014",
        name: "Kagero Okuta",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Muddiness"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/a/af/Dabi_Anime_Action.png/revision/latest?cb=20191102051038",
        name: "Dabi",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Cremation"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/d/d9/Himiko_Toga_Civilian_Full_Body.png/revision/latest?cb=20170923122104",
        name: "Himiko Toga",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Transform"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/3/3d/Twice_TV_Animation_Design.png/revision/latest?cb=20180313231956",
        name: "Jin Bubaigawara",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Double"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/b/b1/Spinner_TV_Animation_Design.png/revision/latest?cb=20180313231732",
        name: "Shuichi Iguchi",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Gecko"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/1/1a/Mr._Compress_TV_Animation_Design.png/revision/latest?cb=20180313231706",
        name: "Sako Atsuhiro",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Compress"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/a/a7/Magne_TV_Animation_Design.png/revision/latest?cb=20180313230730",
        name: "Kenji Hikiishi",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Magnetism"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/7/70/Muscular_anime_profile.png/revision/latest?cb=20180212134717",
        name: "Muscular",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Muscle Augmentation"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/3/3e/Mustard_TV_Animation_Design.png/revision/latest?cb=20180212134337",
        name: "Mustard",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Gas"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/2/21/Moonfish_TV_Animation_Design.png/revision/latest?cb=20180212134641",
        name: "Moonfish",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Blade-Tooth"
    },
    {
        id: v4.generate(),
        image: "https://vignette.wikia.nocookie.net/bokunoheroacademia/images/1/1c/Tool_Arms.png/revision/latest?cb=20180512121535",
        name: "Nomu (Chainsaw)",
        characterClass: "League of Villains",
        category: "Villains",
        quirk: "Tool Arms"
    },
];

export default characterList;
