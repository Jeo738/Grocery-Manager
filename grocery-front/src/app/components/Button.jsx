import React from 'react'

export default function Button({name}) {
  return (
    <div>
        <button className='p-2 mt-3 bg-blue-400 rounded-lg text-white px-4 hover:bg-transparent hover:text-black hover:border border-blue-400'>{name}</button>
    </div>
  )
}
