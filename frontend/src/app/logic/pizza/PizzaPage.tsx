import React from 'react';
import usePizza from 'app/logic/pizza/usePizza';
import {Input, Spin} from 'antd';
import PizzaItemView from 'app/logic/pizza/PizzaItemView';
import 'app/logic/pizza/PizzaPage.css';

export default function PizzaPage() {
    const {pizza, loading, searchParams: {text, handleChangeText}} = usePizza();

    return (
        <div className='pizza-page'>
            <div>
                <Input allowClear title='Search:' className='pizza-search' placeholder='Text search' type='text'
                       value={text}
                       onChange={handleChangeSearchText}/>
            </div>
            {loading ? <Spin/> :
                <div className='pizza-list'>
                    {pizza.map((item) => <PizzaItemView key={item.id} pizza={item}/>)}
                </div>
            }
        </div>
    )

    function handleChangeSearchText(event: any) {
        handleChangeText(event.target.value);
    }
}
