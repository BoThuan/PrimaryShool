PGDMP                     
    y            primaryschool    14.0    14.0 <    L           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            M           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            N           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            O           1262    16394    primaryschool    DATABASE     q   CREATE DATABASE primaryschool WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primaryschool;
                postgres    false            �            1259    16481    tbl_assignment    TABLE     
  CREATE TABLE public.tbl_assignment (
    mapc character varying(255) NOT NULL,
    ca character varying(10) NOT NULL,
    hoc_ky character varying(10) NOT NULL,
    ma_lop character varying(255),
    ma_mon character varying(255),
    magv character varying(255)
);
 "   DROP TABLE public.tbl_assignment;
       public         heap    postgres    false            �            1259    16489    tbl_attendance    TABLE     �   CREATE TABLE public.tbl_attendance (
    madd integer NOT NULL,
    co boolean,
    ngay timestamp without time zone,
    ma_lop character varying(255),
    mahs character varying(255),
    mapl character varying(255)
);
 "   DROP TABLE public.tbl_attendance;
       public         heap    postgres    false            �            1259    16488    tbl_attendance_madd_seq    SEQUENCE     �   CREATE SEQUENCE public.tbl_attendance_madd_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.tbl_attendance_madd_seq;
       public          postgres    false    212            P           0    0    tbl_attendance_madd_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.tbl_attendance_madd_seq OWNED BY public.tbl_attendance.madd;
          public          postgres    false    211            �            1259    16497    tbl_classroom    TABLE       CREATE TABLE public.tbl_classroom (
    ma_lop character varying(255) NOT NULL,
    khoi character varying(255),
    ten_lop character varying(255),
    year timestamp without time zone,
    ma_giao_vu character varying(255),
    magv character varying(255)
);
 !   DROP TABLE public.tbl_classroom;
       public         heap    postgres    false            �            1259    16416 	   tbl_grade    TABLE     t   CREATE TABLE public.tbl_grade (
    ma_khoi character varying(255) NOT NULL,
    ten_khoi character varying(255)
);
    DROP TABLE public.tbl_grade;
       public         heap    postgres    false            �            1259    16504    tbl_license    TABLE     >  CREATE TABLE public.tbl_license (
    magp character varying(255) NOT NULL,
    bat_dau timestamp without time zone,
    duyet boolean,
    ket_thuc timestamp without time zone,
    ly_do character varying(255),
    ngay timestamp without time zone,
    maph character varying(255),
    mapl character varying(255)
);
    DROP TABLE public.tbl_license;
       public         heap    postgres    false            �            1259    16511    tbl_ministry    TABLE     +  CREATE TABLE public.tbl_ministry (
    ma_giao_vu character varying(255) NOT NULL,
    chuc_vu character varying(255),
    dia_chi character varying(255),
    email character varying(255),
    ghi_chu character varying(255),
    sdt character varying(255),
    ten_giao_vu character varying(255)
);
     DROP TABLE public.tbl_ministry;
       public         heap    postgres    false            �            1259    16518    tbl_parents    TABLE     �   CREATE TABLE public.tbl_parents (
    maph character varying(255) NOT NULL,
    ghi_chu character varying(255),
    quan_he character varying(255),
    sdt character varying(255),
    tenph character varying(255)
);
    DROP TABLE public.tbl_parents;
       public         heap    postgres    false            �            1259    16525    tbl_results    TABLE     5  CREATE TABLE public.tbl_results (
    makq character varying(255) NOT NULL,
    diem_cuoik1 double precision,
    diem_cuoik2 double precision,
    diem_giuak1 double precision,
    diem_giuak2 double precision,
    diemkt double precision,
    mapc character varying(255),
    mapl character varying(255)
);
    DROP TABLE public.tbl_results;
       public         heap    postgres    false            �            1259    16532    tbl_students    TABLE     =  CREATE TABLE public.tbl_students (
    mahs character varying(255) NOT NULL,
    dia_chi character varying(255),
    ghi_chu character varying(255),
    gioi_tinh boolean,
    ngay_sinh timestamp without time zone,
    tenhs character varying(255),
    maph character varying(255),
    mapl character varying(255)
);
     DROP TABLE public.tbl_students;
       public         heap    postgres    false            �            1259    16539    tbl_subclass    TABLE     �   CREATE TABLE public.tbl_subclass (
    mapl character varying(255) NOT NULL,
    diemtbnam double precision,
    hanh_kiem character varying(255),
    xep_loai character varying(255),
    ma_lop character varying(255)
);
     DROP TABLE public.tbl_subclass;
       public         heap    postgres    false            �            1259    16546    tbl_subjects    TABLE     ~   CREATE TABLE public.tbl_subjects (
    ma_mon character varying(255) NOT NULL,
    ten_mon character varying(300) NOT NULL
);
     DROP TABLE public.tbl_subjects;
       public         heap    postgres    false            �            1259    16553    tbl_teachers    TABLE     =  CREATE TABLE public.tbl_teachers (
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
       public         heap    postgres    false            �           2604    16492    tbl_attendance madd    DEFAULT     z   ALTER TABLE ONLY public.tbl_attendance ALTER COLUMN madd SET DEFAULT nextval('public.tbl_attendance_madd_seq'::regclass);
 B   ALTER TABLE public.tbl_attendance ALTER COLUMN madd DROP DEFAULT;
       public          postgres    false    211    212    212            >          0    16481    tbl_assignment 
   TABLE DATA           P   COPY public.tbl_assignment (mapc, ca, hoc_ky, ma_lop, ma_mon, magv) FROM stdin;
    public          postgres    false    210   �O       @          0    16489    tbl_attendance 
   TABLE DATA           L   COPY public.tbl_attendance (madd, co, ngay, ma_lop, mahs, mapl) FROM stdin;
    public          postgres    false    212   #P       A          0    16497    tbl_classroom 
   TABLE DATA           V   COPY public.tbl_classroom (ma_lop, khoi, ten_lop, year, ma_giao_vu, magv) FROM stdin;
    public          postgres    false    213   hP       =          0    16416 	   tbl_grade 
   TABLE DATA           6   COPY public.tbl_grade (ma_khoi, ten_khoi) FROM stdin;
    public          postgres    false    209   �P       B          0    16504    tbl_license 
   TABLE DATA           ^   COPY public.tbl_license (magp, bat_dau, duyet, ket_thuc, ly_do, ngay, maph, mapl) FROM stdin;
    public          postgres    false    214   Q       C          0    16511    tbl_ministry 
   TABLE DATA           f   COPY public.tbl_ministry (ma_giao_vu, chuc_vu, dia_chi, email, ghi_chu, sdt, ten_giao_vu) FROM stdin;
    public          postgres    false    215   2Q       D          0    16518    tbl_parents 
   TABLE DATA           I   COPY public.tbl_parents (maph, ghi_chu, quan_he, sdt, tenph) FROM stdin;
    public          postgres    false    216   VR       E          0    16525    tbl_results 
   TABLE DATA           s   COPY public.tbl_results (makq, diem_cuoik1, diem_cuoik2, diem_giuak1, diem_giuak2, diemkt, mapc, mapl) FROM stdin;
    public          postgres    false    217   S       F          0    16532    tbl_students 
   TABLE DATA           g   COPY public.tbl_students (mahs, dia_chi, ghi_chu, gioi_tinh, ngay_sinh, tenhs, maph, mapl) FROM stdin;
    public          postgres    false    218   dS       G          0    16539    tbl_subclass 
   TABLE DATA           T   COPY public.tbl_subclass (mapl, diemtbnam, hanh_kiem, xep_loai, ma_lop) FROM stdin;
    public          postgres    false    219   4T       H          0    16546    tbl_subjects 
   TABLE DATA           7   COPY public.tbl_subjects (ma_mon, ten_mon) FROM stdin;
    public          postgres    false    220   �T       I          0    16553    tbl_teachers 
   TABLE DATA           g   COPY public.tbl_teachers (magv, dia_chi, email, ghi_chu, gioi_tinh, ngay_sinh, sdt, tengv) FROM stdin;
    public          postgres    false    221   �U       Q           0    0    tbl_attendance_madd_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tbl_attendance_madd_seq', 1, false);
          public          postgres    false    211            �           2606    16487 "   tbl_assignment tbl_assignment_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT tbl_assignment_pkey PRIMARY KEY (mapc);
 L   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT tbl_assignment_pkey;
       public            postgres    false    210            �           2606    16496 "   tbl_attendance tbl_attendance_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT tbl_attendance_pkey PRIMARY KEY (madd);
 L   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT tbl_attendance_pkey;
       public            postgres    false    212            �           2606    16503     tbl_classroom tbl_classroom_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT tbl_classroom_pkey PRIMARY KEY (ma_lop);
 J   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT tbl_classroom_pkey;
       public            postgres    false    213            �           2606    16422    tbl_grade tbl_grade_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.tbl_grade
    ADD CONSTRAINT tbl_grade_pkey PRIMARY KEY (ma_khoi);
 B   ALTER TABLE ONLY public.tbl_grade DROP CONSTRAINT tbl_grade_pkey;
       public            postgres    false    209            �           2606    16510    tbl_license tbl_license_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT tbl_license_pkey PRIMARY KEY (magp);
 F   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT tbl_license_pkey;
       public            postgres    false    214            �           2606    16517    tbl_ministry tbl_ministry_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_ministry
    ADD CONSTRAINT tbl_ministry_pkey PRIMARY KEY (ma_giao_vu);
 H   ALTER TABLE ONLY public.tbl_ministry DROP CONSTRAINT tbl_ministry_pkey;
       public            postgres    false    215            �           2606    16524    tbl_parents tbl_parents_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_parents
    ADD CONSTRAINT tbl_parents_pkey PRIMARY KEY (maph);
 F   ALTER TABLE ONLY public.tbl_parents DROP CONSTRAINT tbl_parents_pkey;
       public            postgres    false    216            �           2606    16531    tbl_results tbl_results_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT tbl_results_pkey PRIMARY KEY (makq);
 F   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT tbl_results_pkey;
       public            postgres    false    217            �           2606    16538    tbl_students tbl_students_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT tbl_students_pkey PRIMARY KEY (mahs);
 H   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT tbl_students_pkey;
       public            postgres    false    218            �           2606    16545    tbl_subclass tbl_subclass_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT tbl_subclass_pkey PRIMARY KEY (mapl);
 H   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT tbl_subclass_pkey;
       public            postgres    false    219            �           2606    16552    tbl_subjects tbl_subjects_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT tbl_subjects_pkey PRIMARY KEY (ma_mon);
 H   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT tbl_subjects_pkey;
       public            postgres    false    220            �           2606    16559    tbl_teachers tbl_teachers_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_teachers
    ADD CONSTRAINT tbl_teachers_pkey PRIMARY KEY (magv);
 H   ALTER TABLE ONLY public.tbl_teachers DROP CONSTRAINT tbl_teachers_pkey;
       public            postgres    false    221            �           2606    16561 )   tbl_subjects uk_219alwpgc1hxr67m5bv4jm3nf 
   CONSTRAINT     g   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf UNIQUE (ten_mon);
 S   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf;
       public            postgres    false    220            �           2606    16627 (   tbl_students fk2asbbl0f2wks2u7av24fg34g2    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2;
       public          postgres    false    218    219    3228            �           2606    16632 (   tbl_subclass fk3ntcg1ws4utr7hym00qewjvn6    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6 FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 R   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6;
       public          postgres    false    213    219    3216            �           2606    16577 *   tbl_attendance fk99ep84g5vh5cm15jaxwodig3r    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r;
       public          postgres    false    213    212    3216            �           2606    16622 (   tbl_students fk9eijv8weg8w3y5igkgvdvkpup    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup;
       public          postgres    false    218    216    3222            �           2606    16582 *   tbl_attendance fkclhehr4uqapokd3ftn3i18716    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fkclhehr4uqapokd3ftn3i18716 FOREIGN KEY (mahs) REFERENCES public.tbl_students(mahs);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fkclhehr4uqapokd3ftn3i18716;
       public          postgres    false    212    3226    218            �           2606    16612 '   tbl_results fkco0l0i8v54yeoxchmmg8p9qqp    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp FOREIGN KEY (mapc) REFERENCES public.tbl_assignment(mapc);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp;
       public          postgres    false    210    217    3212            �           2606    16587 *   tbl_attendance fkcqjkcfilyoagaol71wpmb7j8g    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g;
       public          postgres    false    219    3228    212            �           2606    16597 )   tbl_classroom fkdqmcbxsjfc0qneow7rta783vw    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT fkdqmcbxsjfc0qneow7rta783vw FOREIGN KEY (magv) REFERENCES public.tbl_teachers(magv);
 S   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT fkdqmcbxsjfc0qneow7rta783vw;
       public          postgres    false    3234    221    213            �           2606    16602 '   tbl_license fkeftmvx3cj8xtpc3b08be039b5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5 FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5;
       public          postgres    false    214    3222    216            �           2606    16617 '   tbl_results fkfpu9y8umfxlw649mlqch52iv5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5;
       public          postgres    false    3228    217    219            �           2606    16607 '   tbl_license fkgcu9bjptwpy90lqq4g5321y4e    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e;
       public          postgres    false    219    3228    214            �           2606    16567 *   tbl_assignment fkja966hs64yhf5gvi681chqfnq    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkja966hs64yhf5gvi681chqfnq FOREIGN KEY (ma_mon) REFERENCES public.tbl_subjects(ma_mon);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkja966hs64yhf5gvi681chqfnq;
       public          postgres    false    210    220    3230            �           2606    16562 *   tbl_assignment fkpv8oihopumgfijy54yu689bud    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkpv8oihopumgfijy54yu689bud FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkpv8oihopumgfijy54yu689bud;
       public          postgres    false    213    3216    210            �           2606    16572 *   tbl_assignment fkq8fevylmjc9nif9o90gr5he7x    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkq8fevylmjc9nif9o90gr5he7x FOREIGN KEY (magv) REFERENCES public.tbl_teachers(magv);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkq8fevylmjc9nif9o90gr5he7x;
       public          postgres    false    221    3234    210            �           2606    16592 )   tbl_classroom fkriyu6mj3b2kcu8i2twd9xi0nq    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq FOREIGN KEY (ma_giao_vu) REFERENCES public.tbl_ministry(ma_giao_vu);
 S   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq;
       public          postgres    false    215    3220    213            >   2   x��p6000�AgG ۘ3đ�=$���5B�5���q��qqq ��%      @   5   x�3�,�4202�54�50V00�#NgGCN�`0��b�q��qqq w
      A   �   x���1�0����\���N���,U7�z�s#1Y�-y���붐�h�@(y�<1��{_<߯�]si�^�?�_/���b~�_�W(t�_�_���cw{EA���fv�;���?�l�٨��qN)} �]X�      =      x������ � �      B      x������ � �      C     x�u�?K1�9��'h��rw�ĥ�JQ8;u9:�x)"8����ꤝ��
n����&M���Q�$�/��&ׄ���3��E�q�M�����ҙl_�yEE��o���YQ��Mo6��t�e<q�J4.��3
��x�J�(]��%"����<�Fee�u�X��4�L����R�+���?�A�l�\i��
�$�H^p_+u"���F�Q�g�O\�u��Ǭ-�9 QH��T�8�u�zD�?��9�����7V�P�=��1��¶      D   �   x�]�;�0��9ENP%v�k'�"$V����Q�t�P�`�z�6#'�Mŋ=���H%�����D��� o�!�[ǋ6����kyVJV,gs���ъP��*��4�N+�1��Y�#1�k^^ҨV�f3=�&ES�i$��L����f�zyjA�N��;�����2׬:0�~��U�      E   >   x��4 CNsNNKNCNK=cN� g��o�X��������B����Ȉ+F��� P/m      F   �   x�}�1� ���q
.���n:1TӤk����b��'�(=Mobiy&u�0����[=/4$�!@w�+��4*]I��?�� ���&�i�<%�����sS�C!��@����f���k�5�4�۶͔Ҕk;�k.i�E���.�>����IsP��MG-;�cͱFI+��*ٯmI��P�4~7˚�N��Mx�      G   �   x���1 CNK=Sΐ��'�p�g>�ݟ�����0��0�4���8��3��4/]����*�*cN=Kl�X�T�p�C��f�e`���1~�N�W*xg 5�BT*��g �j/P�}�ku��{���Psa:�H�i����� :�V      H   �   x�=�?
�0���N�N�
�]J���d0]<�"�v,���ڇ8ċ����8��|� dz�5��2c�ƈ���M>l�V`��T���[m���J�w3�����y���|Ι;2�Ei��+2�������������ܸe_��Z ���I�      I   V  x�u��J�@�ϛ��H��vvO6ZP�b驗R0顩�z.�D�<XD��<���&n�i�0�2�����v9SH��.`u����B�\�a�����( Np��K���z�xʂ��ϝ`27F�	t�9㞇6r3���C�%���b� ���2�Wв��a�d:���b/�g�"���b�=���҇Y�Ý��Y�81�r��!<%	��?��j��5��;��U���Z~�l�m.ָ.��Hn��-�MS�����$[,?�3�ɼ_�|��6�;6ϦB8�`�w��S��q����Tl��)�J��>Ga�)�� ��T}zɥ਼��}kа,��6��     