import React from 'react';
import usePizza from 'app/logic/pizza/usePizza';
import {Spin} from 'antd';
import PizzaItemView from 'app/logic/pizza/PizzaItemView';
import 'app/logic/pizza/PizzaPage.css';

export default function PizzaPage() {
    const {pizza, loading} = usePizza();

    return (
        <div className='pizza-page'>
            {loading ? <Spin/> :
                <div className='pizza-list'>
                    {pizza.map((item) => <PizzaItemView key={item.id} pizza={item}/>)}
                </div>
            }
        </div>
    )
}
