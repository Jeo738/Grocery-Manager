import React from 'react'

export default function Input({type, placeholder}) {
  return (
    <div>
        <input className='border border-slate-400 p-1 rounded-lg mt-2 px-10' placeholder={placeholder} type={type} />
    </div>
  )
}
