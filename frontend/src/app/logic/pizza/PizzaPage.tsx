import React from 'react';
import usePizza from 'app/logic/pizza/usePizza';
import {Input, Spin} from 'antd';
import PizzaItemView from 'app/logic/pizza/PizzaItemView';
import 'app/logic/pizza/PizzaPage.css';
import {PizzaService} from 'app/service/PizzaService';

export default function PizzaPage() {
    const {pizza, loading, loadPizza, searchParams: {text, handleChangeText}} = usePizza();

    return (
        <div className='pizza-page'>
            <div>
                <Input allowClear title='Поиск:' className='pizza-search' placeholder='Поиск' type='text'
                       value={text}
                       onChange={handleChangeSearchText}/>
            </div>
            {loading ? <Spin/> :
                <div className='pizza-list'>
                    {pizza.map((item) => <PizzaItemView handleDelete={getDeletePizzaHandler(item.id)} key={item.id}
                                                        pizza={item}/>)}
                </div>
            }

            {
                !loading && !pizza.length &&
                <div className='pizza-list'>
                    Пиццы не найдены.
                </div>
            }
        </div>
    )

    function handleChangeSearchText(event: any) {
        handleChangeText(event.target.value);
    }

    function getDeletePizzaHandler(id: string) {
        return () => {
            PizzaService.deletePizza(id).then(() => loadPizza())
        }
    }
}
