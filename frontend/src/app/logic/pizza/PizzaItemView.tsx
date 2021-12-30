import {Pizza} from 'app/model/Pizza';
import {Card} from 'antd';
import img from 'app/assets/pizza.png';
import PizzaPrice from 'app/components/PizzaPrice';
import 'app/logic/pizza/PizzaItemView.css';

const {Meta} = Card;

export default function PizzaItemView({pizza}: { pizza: Pizza }) {

    const cover = <img alt="example" src={img}/>;

    return (
        <div className='pizza-item'>
            <Card
                hoverable
                style={{width: 240}}
                cover={cover}
            >
                <Meta title={<PizzaItemTitle name={pizza.name} price={pizza.price}/>} description={pizza.description}/>
            </Card>
        </div>
    )
}

function PizzaItemTitle({name, price}: { name: string, price: number }) {
    return (
        <div className='pizza-item-header'>
            <span>{name}</span>
            <PizzaPrice price={price}/>
        </div>
    )
}
