import {Button, Form, Input, InputNumber, message} from 'antd';
import AppForm from 'app/components/AppForm';
import 'app/logic/create-pizza/CreatePizzaPage.css';
import TextArea from 'antd/es/input/TextArea';
import {useForm} from 'antd/es/form/Form';
import {Pizza} from 'app/model/Pizza';
import {PizzaService} from 'app/service/PizzaService';

export default function CreatePizzaPage() {
    const [form] = useForm();

    return (
        <div className='create-pizza-page'>
            <AppForm className='create-pizza-form' layout="vertical" form={form} onFinish={handleCreate}  style={{
                marginTop: 20
            }}>
                <Form.Item style={{
                    width: 500
                }} name='name' label='Имя' rules={[{required: true, message: 'Предоставьте Имя'}]}>
                    <Input/>
                </Form.Item>
                <Form.Item style={{
                    width: 500
                }} name='description' label='Описание'
                           rules={[{required: true, message: 'Предоставьте описание'}]}>
                    <TextArea/>
                </Form.Item>
                <Form.Item style={{
                    width: 500
                }} name='price' label='Цена' rules={[{required: true, message: 'Предоставьте цену'}]}>
                    <InputNumber min={1} max={10000}  style={{
                        width: 500
                    }}/>
                </Form.Item>
                <Form.Item name='weight' label='Вес' rules={[{required: true, message: 'Предоставьте вес'}]} style={{
                    width: 500
                }}>
                    <InputNumber min={1} max={10000}  style={{
                        width: 500
                    }}/>
                </Form.Item>
                <Form.Item>
                    <Button htmlType='submit'>
                        Создать пиццу
                    </Button>
                </Form.Item>
            </AppForm>
        </div>
    )

    function handleCreate(values: Pizza) {
        PizzaService.createPizza(values)
            .then(() => {
                message.success('Пицца создана')
            })
            .finally(() => {
                form.resetFields();
            })
    }
}
