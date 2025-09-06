import React from 'react';

const BankingHero = () => {
  return (
    <header className="hero-gradient text-white py-20 px-6 rounded-2xl shadow-[0px_4px_10px_rgba(0,0,0,0.25)] mb-12 animate-fade-in relative overflow-hidden">
      <div className="absolute inset-0 bg-gradient-to-br from-fintech-pink/20 to-fintech-magenta/20 backdrop-blur-sm"></div>
      <div className="relative max-w-6xl mx-auto text-center">
        <div className="float-icon mb-8">
          <div className="w-20 h-20 mx-auto glass rounded-full flex items-center justify-center">
            <span className="text-4xl">💳</span>
          </div>
        </div>
        <h1 className="text-6xl md:text-7xl font-extrabold mb-6 tracking-tight uppercase">
          ZENITH BANK
        </h1>
        <h2 className="text-4xl md:text-5xl font-bold mb-8 text-fintech-light">
          FIXED DEPOSITS
        </h2>
        <p className="text-xl md:text-2xl font-medium max-w-3xl mx-auto mb-10 text-fintech-light/90">
          Next-generation banking for secure investments with industry-leading returns
        </p>
        <div className="flex flex-col sm:flex-row gap-6 justify-center">
          <button className="btn-fintech px-10 py-4 text-lg font-semibold">
            EXPLORE PRODUCTS
          </button>
          <button className="btn-fintech-outline px-10 py-4 text-lg font-semibold">
            CALCULATE RETURNS
          </button>
        </div>
      </div>
    </header>
  );
};

export default BankingHero;