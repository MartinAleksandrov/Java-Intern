const currentDate = dayjs().for('MMMM D');
console.log(currentDate);

const socks = 10;
const shirt = 8;

const total = shirt + socks;

const div = (
    <div>
        <p>Today is {currentDate}</p>
        <p>Cotton socks</p>
        <p>Price: 10</p>
        <button>Add to Cart</button>
        <p>Product cost: ${total}</p>
    </div>
);

const container = document.querySelector('.js-container');
ReactDOM.createRoot(container).render(div);