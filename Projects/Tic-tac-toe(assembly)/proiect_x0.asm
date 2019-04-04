.386
.model flat, stdcall
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;includem biblioteci, si declaram ce functii vrem sa importam
includelib msvcrt.lib
extern exit: proc
extern malloc: proc
extern memset: proc
extern printf: proc

includelib canvas.lib
extern BeginDrawing: proc
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;declaram simbolul start ca public - de acolo incepe executia
public start
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;sectiunile programului, date, respectiv cod
.data
;aici declaram date
window_title DB "Exemplu proiect desenare",0
area_width EQU 650
area_height EQU 650
area DD 0
counter DD 0 ; numara evenimentele de tip timer
numar DD 0

format db "Numarul este %d"

arg1 EQU 8
arg2 EQU 12
arg3 EQU 16
arg4 EQU 20

symbol_width EQU 10
symbol_height EQU 20
include digits.inc
include letters.inc

.code
; procedura make_text afiseaza o litera sau o cifra la coordonatele date
; arg1 - simbolul de afisat (litera sau cifra)
; arg2 - pointer la vectorul de pixeli
; arg3 - pos_x
; arg4 - pos_y

linie_verticala macro x, y
LOCAL bucla
	
	pusha
	mov edi, area
	mov esi, area_width 
	
	shl esi, 2
	mov eax, y;[ebp + arg3] 	;eax = y
	
	mov ebx, area_width
	mul ebx		;pana aici avem y * area_width
	
	add eax, x;[ebp + arg2] 	;y * width + x
	shl eax, 2
	mov ecx, 375
	;mov ecx, area_height
	;sub ecx, [ebp + arg3]	;in ecx o sa aveam inaltimea liniei ce trebuie desenata
	
	bucla:
		mov ebx, eax
		add ebx, edi
		mov dword ptr[ebx], 244
		add eax, esi
	loop bucla
	popa
ENDM	

linie_orizontala macro x, y
LOCAL bucla
	
	pusha
	mov edi, area
	mov esi, area_height 
	
	shl esi, 2
	mov eax, x;[ebp + arg3] 	;eax = x
	
	mov ebx, area_height
	mul ebx		;pana aici avem x * area_height
	
	add eax, y;[ebp + arg2] 	;x * height + x
	shl eax, 2
	mov ecx, 375
	;mov ecx, area_height
	;sub ecx, [ebp + arg3]	;in ecx o sa aveam inaltimea liniei ce trebuie desenata
	
	bucla:
		mov ebx, eax
		add ebx, edi
		mov dword ptr[ebx], 240
		add eax, 4
	loop bucla
	popa
ENDM	

desenez_x macro x, y
LOCAL bucla,bucla1

	pusha
	mov edi,area
	mov eax, x
	mov edx, area_width
	mul edx ; ne am pozitionat pe linia de start
	add eax, y ; ne am pozitionat pe pozitia de start
	shl eax, 2
	
	mov ecx, 125
	mov esi, area_width
	shl esi, 2
	
	bucla:
	
		mov ebx, eax
		add ebx, edi
		mov dword ptr[ebx], 10
		add eax, esi
		add eax, 4
	
	loop bucla
	
	mov edi,area
	mov eax, x
	mov edx, area_width
	mul edx ; ne am pozitionat pe linia de start
	add eax, y ; ne am pozitionat pe pozitia de start
	shl eax, 2
	
	mov ecx, 125
	mov esi, area_width
	shl esi, 2
	
	add eax, 500 ; 125 inmultit cu 4
	
	bucla1:
	
		mov ebx, eax
		add ebx, edi
		mov dword ptr[ebx], 10
		add eax, esi
		sub eax, 4
	
	loop bucla1
	
ENDM

desenez_0 macro x, y
LOCAL bucla, bucla1, bucla2, bucla3
	pusha
	
	mov edi, area
	mov esi, area_width 
	
	shl esi, 2
	mov eax, x;[ebp + arg3] 	;eax = y
	
	mov ebx, area_width
	mul ebx		;pana aici avem y * area_width
	
	add eax, y;[ebp + arg2] 	;y * width + x
	add eax, 60
	shl eax, 2
	
	mov ecx, 65
	bucla:
	
	mov ebx, eax
	add ebx, edi
	mov dword ptr[ebx], 240
	add eax, esi
	add eax, 4
	
	loop bucla
	
	mov ecx, 60
	
	bucla1:
	
	mov ebx, eax
	add ebx, edi
	mov dword ptr[ebx], 240
	add eax, esi
	sub eax, 4
	
	loop bucla1
	
	mov ecx, 65
	
	bucla2:
	
	mov ebx, eax
	add ebx, edi
	mov dword ptr[ebx], 240
	sub eax, esi
	sub eax, 4
	
	loop bucla2
	
	mov ecx, 61
	
	bucla3:
	
	mov ebx, eax
	add ebx, edi
	mov dword ptr[ebx], 240
	sub eax, esi
	add eax, 4
	
	loop bucla3
	
	popa

endm

make_text proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1] ; citim simbolul de afisat
	cmp eax, 'A'
	jl make_digit
	cmp eax, 'Z'
	jg make_digit
	sub eax, 'A'
	lea esi, letters
	jmp draw_text
make_digit:
	cmp eax, '0'
	jl make_space
	cmp eax, '9'
	jg make_space
	sub eax, '0'
	lea esi, digits
	jmp draw_text
make_space:	
	mov eax, 26 ; de la 0 pana la 25 sunt litere, 26 e space
	lea esi, letters
	
draw_text:
	mov ebx, symbol_width
	mul ebx
	mov ebx, symbol_height
	mul ebx
	add esi, eax
	mov ecx, symbol_height
bucla_simbol_linii:
	mov edi, [ebp+arg2] ; pointer la matricea de pixeli
	mov eax, [ebp+arg4] ; pointer la coord y
	add eax, symbol_height
	sub eax, ecx
	mov ebx, area_width
	mul ebx
	add eax, [ebp+arg3] ; pointer la coord x
	shl eax, 2 ; inmultim cu 4, avem un DWORD per pixel
	add edi, eax
	push ecx
	mov ecx, symbol_width
bucla_simbol_coloane:
	cmp byte ptr [esi], 0
	je simbol_pixel_alb
	mov dword ptr [edi], 0
	jmp simbol_pixel_next
simbol_pixel_alb:
	mov dword ptr [edi], 0FFFFFFh
simbol_pixel_next:
	inc esi
	add edi, 4
	loop bucla_simbol_coloane
	pop ecx
	loop bucla_simbol_linii
	popa
	mov esp, ebp
	pop ebp
	ret
make_text endp

; un macro ca sa apelam mai usor desenarea simbolului
make_text_macro macro symbol, drawArea, x, y
	push y
	push x
	push drawArea
	push symbol
	call make_text
	add esp, 16
endm

; functia de desenare - se apeleaza la fiecare click
; sau la fiecare interval de 200ms in care nu s-a dat click
; arg1 - evt (0 - initializare, 1 - click, 2 - s-a scurs intervalul fara click)
; arg2 - x
; arg3 - y
draw proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1]
	cmp eax, 1
	jz evt_click
	cmp eax, 2
	jz evt_timer ; nu s-a efectuat click pe nimic
	;mai jos e codul care intializeaza fereastra cu pixeli albi
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	push 255
	push area
	call memset
	
	add esp, 12
	

	linie_verticala 50, 50
	linie_verticala 175, 50
	linie_verticala 300, 50
	linie_verticala 425, 50
	
	linie_orizontala 50, 50
	linie_orizontala 175, 50
	linie_orizontala 300, 50
	linie_orizontala 425, 50
	
	
	make_text_macro 'P', area, 60, 480
	make_text_macro 'L', area, 71, 480
	make_text_macro 'A', area, 82, 480
	make_text_macro 'Y', area, 93, 480
	make_text_macro 'E', area, 104, 480
	make_text_macro 'R', area, 115, 480
	make_text_macro '1', area, 132, 480
	make_text_macro 'C', area, 150, 480
	make_text_macro 'U', area, 161, 480
	make_text_macro 'X', area, 180, 480
	
	make_text_macro 'P', area, 60, 510
	make_text_macro 'L', area, 71, 510
	make_text_macro 'A', area, 82, 510
	make_text_macro 'Y', area, 93, 510
	make_text_macro 'E', area, 104, 510
	make_text_macro 'R', area, 115, 510
	make_text_macro '2', area, 132, 510
	make_text_macro 'C', area, 150, 510
	make_text_macro 'U', area, 161, 510
	make_text_macro 'O', area, 180, 510
	
	make_text_macro 'C', area, 400, 620
	make_text_macro 'I', area, 410, 620
	make_text_macro 'U', area, 420, 620
	make_text_macro 'L', area, 430, 620
	make_text_macro 'E', area, 440, 620
	make_text_macro 'I', area, 450, 620
	
	make_text_macro 'C', area, 480, 620
	make_text_macro 'E', area, 490, 620
	make_text_macro 'Z', area, 500, 620
	make_text_macro 'A', area, 510, 620
	make_text_macro 'R', area, 520, 620
	
	
	
	mov edi, area
	
	; mov esi, area_width
	; shl esi, 2
	; mov eax, 100;[ebp + arg3] 	;eax = y
	; mov ebx, area_width
	; mul ebx		;pana aici avem y * area_width
	
	; add eax, 100 ;[ebp + arg2] 	;y * width + x
	; shl eax, 2
	; mov ecx, area_height
	; sub ecx, 100;[ebp + arg3]	;in ecx o sa aveam inaltimea liniei ce trebuie desenata
	
	; loop1_:
		; mov ebx, eax
		; add ebx, edi
		; mov dword ptr[ebx], 0
		; add eax, esi
	; loop loop1_
	;jmp afisare_litere
	
	jmp evt_timer
	
evt_click:
	
	mov numar, 0
	
	mov ebx, [ebp + arg2]
	mov edx, [ebp + arg3]
	
	cmp ebx, 50
	ja continua
	jb casuta2
	
	continua:
	cmp ebx, 175
	jb continua_1
	ja casuta2
	
	continua_1:
	cmp edx, 50
	jb casuta2
	ja continua_2
	
	continua_2:
	cmp edx, 175
	jb desen
	ja casuta2
	
	desen: 
	cmp numar, 1
	je desen_x
	jne desen_o
	
	desen_x:
	mov numar, 0
	desenez_x 50, 50
	jmp final
	
	desen_o:
	mov numar,1
	desenez_0 50, 50
	jmp final
	
	casuta2:
	
	cmp ebx, 175
	ja continua1
	jb casuta3
	
	continua1:
	cmp ebx, 300
	jb continua2
	ja casuta3
	
	continua2:
	cmp edx, 50
	jb casuta3
	ja continua3
	
	continua3:
	cmp edx, 175
	jb desen_2
	ja casuta3
	
	desen_2:
	cmp numar, 1
	je desen_x2
	jne desen_o2
	
	desen_x2:
	mov numar, 0
	desenez_x 50, 175
	jmp final
	
	desen_o2:
	mov numar,1
	desenez_0 50, 175
	jmp final
	
	casuta3:
	
	cmp ebx, 300
	ja next
	jb casuta4
	
	next:
	cmp ebx, 425
	jb next1
	ja casuta4
	
	next1:
	cmp edx, 50
	jb casuta4
	ja next2
	
	next2:
	cmp edx, 175
	jb desen_3
	ja casuta4
	
	desen_3: desenez_x 50, 300
	
    casuta4:	

	cmp ebx, 50
	ja nexxt
	jb casuta5
	
	nexxt:
	cmp ebx, 175
	jb next_1
	ja casuta5
	
	next_1:
	cmp edx, 175
	jb casuta5
	ja next_2
	
	next_2:
	cmp edx, 300
	jb desen_4
	ja casuta5

	desen_4: desenez_x 175, 50
	
	casuta5:
	
	cmp ebx, 175
	ja go
	jb casuta6
	
	go:
	cmp ebx, 300
	jb go_1
	ja casuta6
	
	go_1:
	cmp edx, 175
	jb casuta6
	ja go_2
	
	go_2:
	cmp edx, 300
	jb desen_5
	ja casuta6
	
	desen_5: desenez_x 175, 175
	
	casuta6:
	
	cmp ebx, 300
	ja goo
	jb casuta7
	
	goo:
	cmp ebx, 425
	jb go1
	ja casuta7
	
	go1:
	cmp edx, 175
	jb casuta7
	ja go2
	
	go2:
	cmp edx, 300
	jb desen_6
	ja casuta7
	
	desen_6: desenez_x 175, 300
	
	casuta7:
	cmp ebx, 50
	ja c7
	jb casuta8
	
	c7:
	cmp ebx, 175
	jb c7_1
	ja casuta8
	
	c7_1:
	cmp edx, 300
	jb casuta8
	ja c7_2
	
	c7_2:
	cmp edx, 425
	jb desen_7
	ja casuta8
	
	desen_7: desenez_x 300, 50
	
	casuta8:
	
	cmp ebx, 175
	ja c8
	jb casuta9
	
	c8:
	cmp ebx, 300
	jb c8_1
	ja casuta9
	
	c8_1:
	cmp edx, 300
	jb casuta9
	ja c8_2
	
	c8_2:
	cmp edx, 425
	jb desen_8
	ja casuta9
	
	desen_8: desenez_x 300, 175
	
	casuta9:
	
	cmp ebx, 300
	ja c9
	jb final
	
	c9:
	cmp ebx, 425
	jb c9_1
	ja final
	
	c9_1:
	cmp edx, 300
	ja c9_2
	jb final
	
	c9_2:
	cmp edx, 425
	jb desen_9
	ja final
	
	desen_9: desenez_x 300, 300
	
	final:
	
evt_timer:

final_draw:
	popa
	mov esp, ebp
	pop ebp
	ret
draw endp

start:
	;alocam memorie pentru zona de desenat
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	call malloc
	add esp, 4
	mov area, eax
	;apelam functia de desenare a ferestrei
	; typedef void (*DrawFunc)(int evt, int x, int y);
	; void __cdecl BeginDrawing(const char *title, int width, int height, unsigned int *area, DrawFunc draw);
	push offset draw
	push area
	push area_height
	push area_width
	push offset window_title
	call BeginDrawing
	add esp, 20
	
	;terminarea programului
	push 0
	call exit
end start