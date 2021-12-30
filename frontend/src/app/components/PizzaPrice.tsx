export default function PizzaPrice({price}: { price: number }) {
    return (
        <span className='pizza-price'>{price}$</span>
    )
}
