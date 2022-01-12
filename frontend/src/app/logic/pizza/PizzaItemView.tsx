import {Pizza} from 'app/model/Pizza';
import {Button, Card} from 'antd';
import img from 'app/assets/pizza.png';
import PizzaPrice from 'app/components/PizzaPrice';
import 'app/logic/pizza/PizzaItemView.css';
import AddToCartPizzaComponent from 'app/logic/pizza/AddToCartPizzaComponent';

const {Meta} = Card;

//todo add hide text when description is too long.
export default function PizzaItemView({pizza, handleDelete}: { pizza: Pizza, handleDelete: () => void; }) {

    const cover = <img alt={`${pizza.name}`} src={img}/>;

    return (
        <div className='pizza-item'>
            <Card
                hoverable
                style={{width: 240}}
                cover={cover}
            >
                <Meta title={<PizzaItemTitle name={pizza.name} price={pizza.price}/>}
                      description={<PizzaItemDescription handleDelete={handleDelete} pizza={pizza}/>}/>
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

function PizzaItemDescription({pizza, handleDelete}: { pizza: Pizza, handleDelete: () => void; }) {
    return (
        <div className='pizza-item-description'>
            <div className='pizza-item-description-weight'>
                <span className='pizza-item-description-weight-title'>Weight:</span> {pizza.weight}
            </div>
            <div className='pizza-item-description-description'>
                {pizza.description}
            </div>
            <div>
                <AddToCartPizzaComponent id={pizza.id}/>
            </div>
            <div>
                <Button danger style={{
                    marginTop: 20
                }} onClick={handleDelete}>
                    Delete pizza
                </Button>
            </div>
        </div>
    )
}
