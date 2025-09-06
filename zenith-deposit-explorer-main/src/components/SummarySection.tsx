import React from 'react';

const SummarySection = () => {
  const summaryItems = [
    {
      title: "HIGHEST RETURN",
      value: "Suryoday SFB Senior Citizen FD (8.40% p.a.)",
      icon: "🏆"
    },
    {
      title: "BALANCED OPTION", 
      value: "DCB Bank FD (7.95% p.a.)",
      icon: "⚖️"
    },
    {
      title: "SENIOR CITIZEN SPECIAL",
      value: "Zenith Bank Senior Plus FD (8.10% p.a.)",
      icon: "👴"
    },
    {
      title: "TAX BENEFIT",
      value: "Zenith Bank Tax Saver FD (Section 80C)",
      icon: "💰"
    },
    {
      title: "WOMEN'S BENEFITS",
      value: "Zenith Bank Women's FD",
      icon: "👩"
    },
    {
      title: "GREEN INVESTMENTS",
      value: "Green Rupee FD & Zenith Bank Green Growth FD",
      icon: "🌱"
    }
  ];

  return (
    <div className="bg-gradient-to-br from-fintech-purple/10 to-fintech-aqua/10 backdrop-blur-sm border-2 border-fintech-purple/30 rounded-2xl p-8 shadow-[0px_4px_10px_rgba(0,0,0,0.25)] animate-scale-in">
      <div className="text-center mb-10">
        <h2 className="text-4xl font-bold text-fintech-light mb-4 uppercase tracking-wider">
          ✅ INVESTMENT SUMMARY
        </h2>
        <p className="text-fintech-grey font-medium text-lg uppercase tracking-wide">
          Best options by category (Aug 2025)
        </p>
      </div>
      
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {summaryItems.map((item, index) => (
          <div 
            key={index}
            className="fintech-card hover:shadow-[0px_8px_20px_rgba(124,58,237,0.3)] transition-all duration-300 hover:scale-105"
            style={{ animationDelay: `${index * 100}ms` }}
          >
            <div className="flex items-start gap-4">
              <div className="w-12 h-12 rounded-xl bg-gradient-to-br from-fintech-purple to-fintech-aqua flex items-center justify-center">
                <span className="text-xl">{item.icon}</span>
              </div>
              <div className="flex-1">
                <h3 className="font-bold text-fintech-dark mb-3 uppercase tracking-wider text-sm">{item.title}:</h3>
                <p className="text-sm font-medium text-fintech-grey financial-data">{item.value}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
      
      <div className="mt-10 text-center">
        <button className="btn-fintech-secondary px-10 py-4 text-lg font-bold uppercase tracking-wider">
          DOWNLOAD COMPARISON
        </button>
      </div>
    </div>
  );
};

export default SummarySection;