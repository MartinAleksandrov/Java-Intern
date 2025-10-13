import image from "../../assets/react-core-concepts.png";
import './Header.css'

function genNumber(max) {
    return (
        Math.floor(Math.random() * max + 1)
    )
}
const name = ["Ivan","Georgi", "Stoyo"];

function Header(){
    const descrtiption = name[genNumber(2)];

    return(
        <header>
            <img src={image} alt="Stylized atom" />
            <h1>React Essentials</h1>
            <p>
                {descrtiption} React concepts you will need for almost any app you are
                going to build!
            </p>
        </header>
    )
}

export default Header;