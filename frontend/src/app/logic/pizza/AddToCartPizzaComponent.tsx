import React from 'react';
import useCart from 'app/logic/useCart';
import {Button, message} from 'antd';

type AddToCartPizzaComponentProps = {
    id: string
}
export default function AddToCartPizzaComponent({id}: AddToCartPizzaComponentProps) {
    const {add, remove, isInCart} = useCart();

    const isPizzaInCart = isInCart(id);

    return (
        <div className='add-to-cart'>
            {!isPizzaInCart &&
                <Button onClick={addToCartPizza}>
                    Add to cart
                </Button>}

            {isPizzaInCart &&
                <Button danger onClick={removeFromCart}>
                    Remove from cart
                </Button>}
        </div>
    )

    function addToCartPizza() {
        add(id);
        message.success('Pizza added to Cart.');
    }

    function removeFromCart() {
        remove(id);
        message.success('Pizza removed from Cart.');
    }
}
