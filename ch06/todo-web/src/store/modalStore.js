import { create } from "zustand";

//zustand : client 전역 상태
// 전역 상태로 해당 isOpen 키만 값이 바뀌면 내려받은 컴포넌트들에 적용
export const useBottomModalStore = create((set) => ({
    isOpen: false,
    children: null,
    
    setOpen: (state) => {
        if (state) {
            set({ isOpen: true });
        } else {
            set({ isOpen: false });
            children: null;
        }
        
    },

    setChildren: (state) => {
        set({ children: state });
    },
}));