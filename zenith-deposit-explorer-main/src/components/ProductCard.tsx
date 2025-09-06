import React from 'react';

interface ProductCardProps {
  title: string;
  bank: string;
  depositRange: string;
  tenure: string;
  interestRate: string;
  payout: string;
  penalty: string;
  extraValue: string;
  icon: string;
  isPremium?: boolean;
  delay?: number;
}

const ProductCard: React.FC<ProductCardProps> = ({
  title,
  bank,
  depositRange,
  tenure,
  interestRate,
  payout,
  penalty,
  extraValue,
  icon,
  isPremium = false,
  delay = 0
}) => {
  return (
    <div 
      className={`${isPremium ? 'fintech-card-premium' : 'fintech-card'} animate-slide-up h-full flex flex-col`}
      style={{ animationDelay: `${delay}ms` }}
    >
      <div className="flex items-center gap-4 mb-6">
        <div className="w-12 h-12 rounded-xl bg-gradient-to-br from-fintech-pink to-fintech-magenta flex items-center justify-center">
          <span className="text-xl">{icon}</span>
        </div>
        <h2 className="text-xl font-bold text-fintech-dark leading-tight uppercase tracking-wide">{title}</h2>
      </div>
      
      <div className="flex-1 space-y-4 text-sm">
        <div className="flex justify-between items-center py-2">
          <span className="font-medium text-fintech-grey uppercase tracking-wider">Bank:</span>
          <span className="font-bold text-fintech-dark">{bank}</span>
        </div>
        
        <div className="flex justify-between items-center py-2">
          <span className="font-medium text-fintech-grey uppercase tracking-wider">Range:</span>
          <span className="font-bold text-fintech-dark financial-data">{depositRange}</span>
        </div>
        
        <div className="flex justify-between items-center py-2">
          <span className="font-medium text-fintech-grey uppercase tracking-wider">Tenure:</span>
          <span className="font-bold text-fintech-dark financial-data">{tenure}</span>
        </div>
        
        <div className="financial-highlight">
          <div className="flex justify-between items-center">
            <span className="font-bold text-fintech-grey uppercase tracking-wider">Interest Rate:</span>
            <span className="highlight-rate text-lg font-bold">{interestRate}</span>
          </div>
        </div>
        
        <div className="flex justify-between items-center py-2">
          <span className="font-medium text-fintech-grey uppercase tracking-wider">Payout:</span>
          <span className="font-bold text-fintech-dark">{payout}</span>
        </div>
        
        <div className="flex justify-between items-center py-2">
          <span className="font-medium text-fintech-grey uppercase tracking-wider">Penalty:</span>
          <span className="font-bold text-fintech-dark">{penalty}</span>
        </div>
        
        <div className="pt-4 border-t border-fintech-grey/20">
          <span className="font-bold text-fintech-grey text-xs uppercase tracking-wider">Extra Value:</span>
          <p className="text-fintech-dark font-medium mt-2">{extraValue}</p>
        </div>
      </div>
      
      <div className="mt-8 pt-6 border-t border-fintech-grey/20">
        <button className={`w-full ${isPremium ? 'btn-fintech-secondary' : 'btn-fintech'} py-4 text-sm font-bold uppercase tracking-wider`}>
          APPLY NOW
        </button>
      </div>
    </div>
  );
};

export default ProductCard;