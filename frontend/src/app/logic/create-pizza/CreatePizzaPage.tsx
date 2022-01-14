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
            <AppForm className='create-pizza-form' layout="vertical" form={form} onFinish={handleCreate}>
                <Form.Item name='name' label='Name' rules={[{required: true, message: 'Provide Name'}]}>
                    <Input/>
                </Form.Item>
                <Form.Item name='description' label='Description'
                           rules={[{required: true, message: 'Provide Description'}]}>
                    <TextArea/>
                </Form.Item>
                <Form.Item name='price' label='Price' rules={[{required: true, message: 'Provide Price'}]}>
                    <InputNumber min={1} max={10000}/>
                </Form.Item>
                <Form.Item name='weight' label='Weight' rules={[{required: true, message: 'Provide Weight'}]}>
                    <InputNumber min={1} max={10000}/>
                </Form.Item>
                <Form.Item>
                    <Button htmlType='submit'>
                        Create Pizza
                    </Button>
                </Form.Item>
            </AppForm>
        </div>
    )

    function handleCreate(values: Pizza) {
        PizzaService.createPizza(values)
            .then(() => {
                message.success('Pizza created.')
            })
            .finally(() => {
                form.resetFields();
            })
    }
}
