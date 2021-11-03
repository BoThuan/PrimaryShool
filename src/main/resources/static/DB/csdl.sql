PGDMP                     	    y            primaryschool    14.0    14.0 4    E           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            F           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            G           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            H           1262    25064    primaryschool    DATABASE     q   CREATE DATABASE primaryschool WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primaryschool;
                postgres    false            �            1259    25065    tbl_assignment    TABLE     �   CREATE TABLE public.tbl_assignment (
    mapc character varying(255) NOT NULL,
    ca character varying(255),
    magv character varying(255),
    ma_lop character varying(255),
    ma_mon character varying(255)
);
 "   DROP TABLE public.tbl_assignment;
       public         heap    postgres    false            �            1259    25070    tbl_attendance    TABLE     �   CREATE TABLE public.tbl_attendance (
    madd integer NOT NULL,
    co boolean,
    ma_lop character varying(255),
    mapl character varying(255),
    ngay timestamp without time zone
);
 "   DROP TABLE public.tbl_attendance;
       public         heap    postgres    false            �            1259    25075    tbl_classroom    TABLE       CREATE TABLE public.tbl_classroom (
    ma_lop character varying(255) NOT NULL,
    khoi character varying(255),
    magv character varying(255),
    ten_lop character varying(255),
    year timestamp without time zone,
    ma_giao_vu character varying(255)
);
 !   DROP TABLE public.tbl_classroom;
       public         heap    postgres    false            �            1259    25080 	   tbl_grade    TABLE     t   CREATE TABLE public.tbl_grade (
    ma_khoi character varying(255) NOT NULL,
    ten_khoi character varying(255)
);
    DROP TABLE public.tbl_grade;
       public         heap    postgres    false            �            1259    25085    tbl_license    TABLE     >  CREATE TABLE public.tbl_license (
    magp character varying(255) NOT NULL,
    bat_dau timestamp without time zone,
    duyet boolean,
    ket_thuc timestamp without time zone,
    ly_do character varying(255),
    maph character varying(255),
    ngay timestamp without time zone,
    mapl character varying(255)
);
    DROP TABLE public.tbl_license;
       public         heap    postgres    false            �            1259    25090    tbl_ministry    TABLE     +  CREATE TABLE public.tbl_ministry (
    ma_giao_vu character varying(255) NOT NULL,
    chuc_vu character varying(255),
    dia_chi character varying(255),
    email character varying(255),
    ghi_chu character varying(255),
    sdt character varying(255),
    ten_giao_vu character varying(255)
);
     DROP TABLE public.tbl_ministry;
       public         heap    postgres    false            �            1259    25095    tbl_parents    TABLE     �   CREATE TABLE public.tbl_parents (
    maph character varying(255) NOT NULL,
    ghi_chu character varying(255),
    quan_he character varying(255),
    sdt character varying(255),
    tenph character varying(255)
);
    DROP TABLE public.tbl_parents;
       public         heap    postgres    false            �            1259    25100    tbl_results    TABLE     �  CREATE TABLE public.tbl_results (
    makq character varying(255) NOT NULL,
    diem15p double precision,
    diem1t double precision,
    diem_mieng double precision,
    mapc character varying(255),
    mapl character varying(255),
    diem_cuoik1 double precision,
    diem_cuoik2 double precision,
    diem_giuak1 double precision,
    diem_giuak2 double precision,
    diemkt double precision
);
    DROP TABLE public.tbl_results;
       public         heap    postgres    false            �            1259    25105    tbl_students    TABLE       CREATE TABLE public.tbl_students (
    mahs character varying(255) NOT NULL,
    dia_chi character varying(255),
    ghi_chu character varying(255),
    gioi_tinh boolean,
    maph character varying(255),
    ngay_sinh timestamp without time zone,
    tenhs character varying(255)
);
     DROP TABLE public.tbl_students;
       public         heap    postgres    false            �            1259    25110    tbl_subclass    TABLE     <  CREATE TABLE public.tbl_subclass (
    mapl character varying(255) NOT NULL,
    diem_ky1 double precision,
    diem_ky2 double precision,
    diemtbnam double precision,
    hanh_kiem character varying(255),
    mahs character varying(255),
    ma_lop character varying(255),
    xep_loai character varying(255)
);
     DROP TABLE public.tbl_subclass;
       public         heap    postgres    false            �            1259    25115    tbl_subjects    TABLE     ~   CREATE TABLE public.tbl_subjects (
    ma_mon character varying(255) NOT NULL,
    ten_mon character varying(300) NOT NULL
);
     DROP TABLE public.tbl_subjects;
       public         heap    postgres    false            �            1259    25120    tbl_teachers    TABLE     =  CREATE TABLE public.tbl_teachers (
    magv character varying(255) NOT NULL,
    dia_chi character varying(255),
    email character varying(255),
    ghi_chu character varying(255),
    gioi_tinh boolean,
    ngay_sinh timestamp without time zone,
    sdt character varying(255),
    tengv character varying(255)
);
     DROP TABLE public.tbl_teachers;
       public         heap    postgres    false            7          0    25065    tbl_assignment 
   TABLE DATA           H   COPY public.tbl_assignment (mapc, ca, magv, ma_lop, ma_mon) FROM stdin;
    public          postgres    false    209   E       8          0    25070    tbl_attendance 
   TABLE DATA           F   COPY public.tbl_attendance (madd, co, ma_lop, mapl, ngay) FROM stdin;
    public          postgres    false    210   �E       9          0    25075    tbl_classroom 
   TABLE DATA           V   COPY public.tbl_classroom (ma_lop, khoi, magv, ten_lop, year, ma_giao_vu) FROM stdin;
    public          postgres    false    211   �E       :          0    25080 	   tbl_grade 
   TABLE DATA           6   COPY public.tbl_grade (ma_khoi, ten_khoi) FROM stdin;
    public          postgres    false    212   zF       ;          0    25085    tbl_license 
   TABLE DATA           ^   COPY public.tbl_license (magp, bat_dau, duyet, ket_thuc, ly_do, maph, ngay, mapl) FROM stdin;
    public          postgres    false    213   �F       <          0    25090    tbl_ministry 
   TABLE DATA           f   COPY public.tbl_ministry (ma_giao_vu, chuc_vu, dia_chi, email, ghi_chu, sdt, ten_giao_vu) FROM stdin;
    public          postgres    false    214   �F       =          0    25095    tbl_parents 
   TABLE DATA           I   COPY public.tbl_parents (maph, ghi_chu, quan_he, sdt, tenph) FROM stdin;
    public          postgres    false    215   gG       >          0    25100    tbl_results 
   TABLE DATA           �   COPY public.tbl_results (makq, diem15p, diem1t, diem_mieng, mapc, mapl, diem_cuoik1, diem_cuoik2, diem_giuak1, diem_giuak2, diemkt) FROM stdin;
    public          postgres    false    216   I       ?          0    25105    tbl_students 
   TABLE DATA           a   COPY public.tbl_students (mahs, dia_chi, ghi_chu, gioi_tinh, maph, ngay_sinh, tenhs) FROM stdin;
    public          postgres    false    217   ]I       @          0    25110    tbl_subclass 
   TABLE DATA           n   COPY public.tbl_subclass (mapl, diem_ky1, diem_ky2, diemtbnam, hanh_kiem, mahs, ma_lop, xep_loai) FROM stdin;
    public          postgres    false    218   �J       A          0    25115    tbl_subjects 
   TABLE DATA           7   COPY public.tbl_subjects (ma_mon, ten_mon) FROM stdin;
    public          postgres    false    219   UK       B          0    25120    tbl_teachers 
   TABLE DATA           g   COPY public.tbl_teachers (magv, dia_chi, email, ghi_chu, gioi_tinh, ngay_sinh, sdt, tengv) FROM stdin;
    public          postgres    false    220   GL       �           2606    25126 "   tbl_assignment tbl_assignment_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT tbl_assignment_pkey PRIMARY KEY (mapc);
 L   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT tbl_assignment_pkey;
       public            postgres    false    209            �           2606    25128 "   tbl_attendance tbl_attendance_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT tbl_attendance_pkey PRIMARY KEY (madd);
 L   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT tbl_attendance_pkey;
       public            postgres    false    210            �           2606    25130     tbl_classroom tbl_classroom_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT tbl_classroom_pkey PRIMARY KEY (ma_lop);
 J   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT tbl_classroom_pkey;
       public            postgres    false    211            �           2606    25132    tbl_grade tbl_grade_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.tbl_grade
    ADD CONSTRAINT tbl_grade_pkey PRIMARY KEY (ma_khoi);
 B   ALTER TABLE ONLY public.tbl_grade DROP CONSTRAINT tbl_grade_pkey;
       public            postgres    false    212            �           2606    25134    tbl_license tbl_license_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT tbl_license_pkey PRIMARY KEY (magp);
 F   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT tbl_license_pkey;
       public            postgres    false    213            �           2606    25136    tbl_ministry tbl_ministry_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_ministry
    ADD CONSTRAINT tbl_ministry_pkey PRIMARY KEY (ma_giao_vu);
 H   ALTER TABLE ONLY public.tbl_ministry DROP CONSTRAINT tbl_ministry_pkey;
       public            postgres    false    214            �           2606    25138    tbl_parents tbl_parents_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_parents
    ADD CONSTRAINT tbl_parents_pkey PRIMARY KEY (maph);
 F   ALTER TABLE ONLY public.tbl_parents DROP CONSTRAINT tbl_parents_pkey;
       public            postgres    false    215            �           2606    25140    tbl_results tbl_results_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT tbl_results_pkey PRIMARY KEY (makq);
 F   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT tbl_results_pkey;
       public            postgres    false    216            �           2606    25142    tbl_students tbl_students_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT tbl_students_pkey PRIMARY KEY (mahs);
 H   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT tbl_students_pkey;
       public            postgres    false    217            �           2606    25144    tbl_subclass tbl_subclass_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT tbl_subclass_pkey PRIMARY KEY (mapl);
 H   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT tbl_subclass_pkey;
       public            postgres    false    218            �           2606    25146    tbl_subjects tbl_subjects_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT tbl_subjects_pkey PRIMARY KEY (ma_mon);
 H   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT tbl_subjects_pkey;
       public            postgres    false    219            �           2606    25148    tbl_teachers tbl_teachers_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_teachers
    ADD CONSTRAINT tbl_teachers_pkey PRIMARY KEY (magv);
 H   ALTER TABLE ONLY public.tbl_teachers DROP CONSTRAINT tbl_teachers_pkey;
       public            postgres    false    220            �           2606    25150 )   tbl_subjects uk_219alwpgc1hxr67m5bv4jm3nf 
   CONSTRAINT     g   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf UNIQUE (ten_mon);
 S   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf;
       public            postgres    false    219            �           2606    25211 (   tbl_subclass fk3ntcg1ws4utr7hym00qewjvn6    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6 FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 R   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6;
       public          postgres    false    211    218    3212            �           2606    25166 *   tbl_attendance fk99ep84g5vh5cm15jaxwodig3r    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r;
       public          postgres    false    210    211    3212            �           2606    25206 (   tbl_students fk9eijv8weg8w3y5igkgvdvkpup    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup;
       public          postgres    false    215    217    3220            �           2606    25196 '   tbl_results fkco0l0i8v54yeoxchmmg8p9qqp    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp FOREIGN KEY (mapc) REFERENCES public.tbl_assignment(mapc);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp;
       public          postgres    false    3208    209    216            �           2606    25171 *   tbl_attendance fkcqjkcfilyoagaol71wpmb7j8g    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g;
       public          postgres    false    218    3226    210            �           2606    25186 '   tbl_license fkeftmvx3cj8xtpc3b08be039b5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5 FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5;
       public          postgres    false    215    3220    213            �           2606    25201 '   tbl_results fkfpu9y8umfxlw649mlqch52iv5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5;
       public          postgres    false    3226    218    216            �           2606    25191 '   tbl_license fkgcu9bjptwpy90lqq4g5321y4e    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e;
       public          postgres    false    213    3226    218            �           2606    25216 (   tbl_subclass fkiyikdm4aux96g9cfp9aew4m1l    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT fkiyikdm4aux96g9cfp9aew4m1l FOREIGN KEY (mahs) REFERENCES public.tbl_students(mahs);
 R   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT fkiyikdm4aux96g9cfp9aew4m1l;
       public          postgres    false    217    218    3224            �           2606    25151 *   tbl_assignment fkpv8oihopumgfijy54yu689bud    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkpv8oihopumgfijy54yu689bud FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkpv8oihopumgfijy54yu689bud;
       public          postgres    false    209    3212    211            �           2606    25176 )   tbl_classroom fkriyu6mj3b2kcu8i2twd9xi0nq    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq FOREIGN KEY (ma_giao_vu) REFERENCES public.tbl_ministry(ma_giao_vu);
 S   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq;
       public          postgres    false    3218    211    214            7   �   x�]�=�0���.E�:&E*�t�:uc�.Y�(����pHl*�h}z�s�H).�{:U
�PF��u�Ϧq<O���ZiR7&��ݖ���+���wJk���96J�6 d˿��A�#銓�����&6��Oş��҉��f�d��c*�$g����ոB���N�      8      x������ � �      9   x   x�u�;�@��z�� h�JD�uC�2�?�eKK.\��I�`��H�Re�.���ǯI�*p�E��~Thii�J��evWBXiY>7Xiy�K���TtxiEG��(��Ym��:���	��F7      :      x������ � �      ;      x������ � �      <   �   x��1000���|���T���؆����s���+8�q:敔e�9��&f��%��r��qXZ����q�=ܵ<O!��J�������Z�`�d��d7�)�g&�I�-�+˃(C3��������f�_zi��ݭ@+oQ��8�(O!��\�=... ��F      =   �  x�]��JA���S�'���)�f�R,!MH�M�	HRXj_�؈��p����{̛xgp�-�s�9�N?%��d�KNC�k4�Z�d�xv0��.C��r8�v�{�	�FC�Ω ̈�7Y^���A�7�"��p���Tr!8�Cy�i(op��(mK��k���<���&e���r�w��;d���Z��v�&�V��)cR�d����?���=
"����XfЅH�y(ֳ
�MBy7�3UQM=�(+�5#]�4Ô~S����LX<Bl<C>��V�)iE$�Fpl�ob'���G��m��h�4^s�Ǟ���ǈ��ULaVR_g��A:ŀˈs<z�÷�MULŗ����I%Q����ǾC�����#˦�K)>���ϡ;�i�,��*��֤�s�����A���I���      >   7   x��4 C�?(
p�|�������M�1T�	v��h�M���Е��qqq �      ?   �  x���=K�@��˧���]�$�[���5,N]J�$CS;8:8��APpi28\���o�{k�E�Ar�{���z��CP��F1z@*�>�0i���������|ˡ���ts�*�����?��)^�����&.�\�7>��j�Ը��%�\��u�,y�1ilH[N��Ғ@~��_�"O Nx�� �3����-#1m,/��q`�}k�C{:c+�j���%�'r��.؏��"��R�B-)TY-���|���mi}5��H�
W�8Oܱ�� ���x<VԋŖB���,�0dk�볗����'�n�O�?q��h�о�*�c���S:d��a]����I*��I`�������j;�F"��$E��f�,�;�]:���(?:sg�k�      @   R   x��1 C�?���:y\`FXTq9!TcQa����
NS$[L��0�4A2��
33̱�0�4������ ��2�      A   �   x�5��JA�띧��R�� $��Z8H�4a���Wx� ZX����!
A,�A,6/2o�1b�|���tf(J��j���w-�ɑ3��.���L�)\I�n�9��F�.b��?���O	b
1�'�8�/��#C�oG�E��Ԗ����}�K�r�G=�x����{8�qI�fs����V=��3��W���=��QK���I��i������Q:'߬���{ ��Rb      B     x�m��j�@��㧘P:�uU�������rj�F�b$C���.J!��
MJ)�]Ŧt!��7����v���ƞo�=���)!�"�8�����I����Q8��h�d�F���x��t6D�A�=B=�0!��"�f>S���U���OWo����[C�dxPܛ1>]߭��9����IL���X�K�Q	�ŕ�D14����]~������(�pU�s��w��3��lV�A���6�J��#£���J�����r��8M�r�3ǎ#����q�n��"G�%��� �o��P���
���\�rDi�+����*�8�-ζ0�G����Z�5�%�M�C[�pV��r���}���aqc���7_���I�c�_�Q��������
Wܤ���& x�m�Ҧ�G]&ydL6ߗ�<�w*��$\�v�Zf�Q`WA@������{����(=PAa#��"�%W>U�Ny8)82G	��5~Z�Z�V<C`L�}��(ߊ��/|T��2�B�P�+<�&��R���/D'��IF���M�Emka>��u�&�;g|�L` Ը�煋�p<�G��Q�-�� )�7���ԣƝΐx`7Fi4{�5uAK�̤��#�S&�Pzӧ�(sy=��ѳ$����4=����g��e���I�;�*ޠ��TK��o\r-�+��t��
�M&���i#n�E�\b�-NJf�HQ35�O�-m>b"����դ\�1�k����R���`6D3�.��P�sv��t�����     