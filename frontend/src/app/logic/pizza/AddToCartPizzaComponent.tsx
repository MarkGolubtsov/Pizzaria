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
                    Добавить в корзину
                </Button>}

            {isPizzaInCart &&
                <Button danger onClick={removeFromCart}>
                    Удалить из корзины
                </Button>}
        </div>
    )

    function addToCartPizza() {
        add(id);
        message.success('Пицца добавлена в корзину');
    }

    function removeFromCart() {
        remove(id);
        message.success('Пицца удалена из корзины');
    }
}
