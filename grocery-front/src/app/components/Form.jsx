import React from 'react'
import Input from './Input'
import Button from './Button'

export default function Form() {
  return (
    <div className='max-w-full flex justify-center items-center min-h-screen'>
      <div className="">
      </div>
      <form action="POST">
        <div className='flex justify-center flex-col bg-slate-100 p-5 rounded-lg border  border-blue-400' >
          <h1 className='text-center text-lg font-medium'>New Product</h1>
          <Input placeholder={'Product Name'} type={'text'}></Input>
          <Input placeholder={'Category'} type={'text'}></Input>
          <Input placeholder={'Bar code'} type={'text'}></Input>
          <Input placeholder={'Expiration Date'} type={'date'}></Input>
          <Button name={'Send'}></Button>
        </div>
      </form>
    </div>
  )
}
