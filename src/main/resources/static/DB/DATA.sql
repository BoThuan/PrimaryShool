PGDMP     4    -            	    y            primaryschool    14.0    14.0 9    E           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            F           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            G           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            H           1262    29169    primaryschool    DATABASE     q   CREATE DATABASE primaryschool WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primaryschool;
                postgres    false            �            1259    29682    tbl_assignment    TABLE     
  CREATE TABLE public.tbl_assignment (
    mapc character varying(255) NOT NULL,
    ca character varying(10) NOT NULL,
    hoc_ky character varying(10) NOT NULL,
    ma_lop character varying(255),
    ma_mon character varying(255),
    magv character varying(255)
);
 "   DROP TABLE public.tbl_assignment;
       public         heap    postgres    false            �            1259    29690    tbl_attendance    TABLE     �   CREATE TABLE public.tbl_attendance (
    madd integer NOT NULL,
    co boolean,
    ngay timestamp without time zone,
    ma_lop character varying(255),
    mahs character varying(255),
    mapl character varying(255)
);
 "   DROP TABLE public.tbl_attendance;
       public         heap    postgres    false            �            1259    29689    tbl_attendance_madd_seq    SEQUENCE     �   CREATE SEQUENCE public.tbl_attendance_madd_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.tbl_attendance_madd_seq;
       public          postgres    false    211            I           0    0    tbl_attendance_madd_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.tbl_attendance_madd_seq OWNED BY public.tbl_attendance.madd;
          public          postgres    false    210            �            1259    29698    tbl_classroom    TABLE       CREATE TABLE public.tbl_classroom (
    ma_lop character varying(255) NOT NULL,
    khoi character varying(255),
    ten_lop character varying(255),
    year timestamp without time zone,
    ma_giao_vu character varying(255),
    magv character varying(255)
);
 !   DROP TABLE public.tbl_classroom;
       public         heap    postgres    false            �            1259    29705    tbl_license    TABLE     >  CREATE TABLE public.tbl_license (
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
       public         heap    postgres    false            �            1259    29712    tbl_ministry    TABLE     +  CREATE TABLE public.tbl_ministry (
    ma_giao_vu character varying(255) NOT NULL,
    chuc_vu character varying(255),
    dia_chi character varying(255),
    email character varying(255),
    ghi_chu character varying(255),
    sdt character varying(255),
    ten_giao_vu character varying(255)
);
     DROP TABLE public.tbl_ministry;
       public         heap    postgres    false            �            1259    29719    tbl_parents    TABLE     �   CREATE TABLE public.tbl_parents (
    maph character varying(255) NOT NULL,
    ghi_chu character varying(255),
    quan_he character varying(255),
    sdt character varying(255),
    tenph character varying(255)
);
    DROP TABLE public.tbl_parents;
       public         heap    postgres    false            �            1259    29726    tbl_results    TABLE     5  CREATE TABLE public.tbl_results (
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
       public         heap    postgres    false            �            1259    29733    tbl_students    TABLE     =  CREATE TABLE public.tbl_students (
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
       public         heap    postgres    false            �            1259    29740    tbl_subclass    TABLE     �   CREATE TABLE public.tbl_subclass (
    mapl character varying(255) NOT NULL,
    diemtbnam double precision,
    hanh_kiem character varying(255),
    xep_loai character varying(255),
    ma_lop character varying(255)
);
     DROP TABLE public.tbl_subclass;
       public         heap    postgres    false            �            1259    29747    tbl_subjects    TABLE     ~   CREATE TABLE public.tbl_subjects (
    ma_mon character varying(255) NOT NULL,
    ten_mon character varying(300) NOT NULL
);
     DROP TABLE public.tbl_subjects;
       public         heap    postgres    false            �            1259    29754    tbl_teachers    TABLE     =  CREATE TABLE public.tbl_teachers (
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
       public         heap    postgres    false            �           2604    29693    tbl_attendance madd    DEFAULT     z   ALTER TABLE ONLY public.tbl_attendance ALTER COLUMN madd SET DEFAULT nextval('public.tbl_attendance_madd_seq'::regclass);
 B   ALTER TABLE public.tbl_attendance ALTER COLUMN madd DROP DEFAULT;
       public          postgres    false    210    211    211            7          0    29682    tbl_assignment 
   TABLE DATA           P   COPY public.tbl_assignment (mapc, ca, hoc_ky, ma_lop, ma_mon, magv) FROM stdin;
    public          postgres    false    209   �L       9          0    29690    tbl_attendance 
   TABLE DATA           L   COPY public.tbl_attendance (madd, co, ngay, ma_lop, mahs, mapl) FROM stdin;
    public          postgres    false    211   �L       :          0    29698    tbl_classroom 
   TABLE DATA           V   COPY public.tbl_classroom (ma_lop, khoi, ten_lop, year, ma_giao_vu, magv) FROM stdin;
    public          postgres    false    212   AM       ;          0    29705    tbl_license 
   TABLE DATA           ^   COPY public.tbl_license (magp, bat_dau, duyet, ket_thuc, ly_do, ngay, maph, mapl) FROM stdin;
    public          postgres    false    213   rM       <          0    29712    tbl_ministry 
   TABLE DATA           f   COPY public.tbl_ministry (ma_giao_vu, chuc_vu, dia_chi, email, ghi_chu, sdt, ten_giao_vu) FROM stdin;
    public          postgres    false    214   �M       =          0    29719    tbl_parents 
   TABLE DATA           I   COPY public.tbl_parents (maph, ghi_chu, quan_he, sdt, tenph) FROM stdin;
    public          postgres    false    215   �M       >          0    29726    tbl_results 
   TABLE DATA           s   COPY public.tbl_results (makq, diem_cuoik1, diem_cuoik2, diem_giuak1, diem_giuak2, diemkt, mapc, mapl) FROM stdin;
    public          postgres    false    216   N       ?          0    29733    tbl_students 
   TABLE DATA           g   COPY public.tbl_students (mahs, dia_chi, ghi_chu, gioi_tinh, ngay_sinh, tenhs, maph, mapl) FROM stdin;
    public          postgres    false    217   2N       @          0    29740    tbl_subclass 
   TABLE DATA           T   COPY public.tbl_subclass (mapl, diemtbnam, hanh_kiem, xep_loai, ma_lop) FROM stdin;
    public          postgres    false    218   �N       A          0    29747    tbl_subjects 
   TABLE DATA           7   COPY public.tbl_subjects (ma_mon, ten_mon) FROM stdin;
    public          postgres    false    219   �N       B          0    29754    tbl_teachers 
   TABLE DATA           g   COPY public.tbl_teachers (magv, dia_chi, email, ghi_chu, gioi_tinh, ngay_sinh, sdt, tengv) FROM stdin;
    public          postgres    false    220   �N       J           0    0    tbl_attendance_madd_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.tbl_attendance_madd_seq', 1, false);
          public          postgres    false    210            �           2606    29688 "   tbl_assignment tbl_assignment_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT tbl_assignment_pkey PRIMARY KEY (mapc);
 L   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT tbl_assignment_pkey;
       public            postgres    false    209            �           2606    29697 "   tbl_attendance tbl_attendance_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT tbl_attendance_pkey PRIMARY KEY (madd);
 L   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT tbl_attendance_pkey;
       public            postgres    false    211            �           2606    29704     tbl_classroom tbl_classroom_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT tbl_classroom_pkey PRIMARY KEY (ma_lop);
 J   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT tbl_classroom_pkey;
       public            postgres    false    212            �           2606    29711    tbl_license tbl_license_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT tbl_license_pkey PRIMARY KEY (magp);
 F   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT tbl_license_pkey;
       public            postgres    false    213            �           2606    29718    tbl_ministry tbl_ministry_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_ministry
    ADD CONSTRAINT tbl_ministry_pkey PRIMARY KEY (ma_giao_vu);
 H   ALTER TABLE ONLY public.tbl_ministry DROP CONSTRAINT tbl_ministry_pkey;
       public            postgres    false    214            �           2606    29725    tbl_parents tbl_parents_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_parents
    ADD CONSTRAINT tbl_parents_pkey PRIMARY KEY (maph);
 F   ALTER TABLE ONLY public.tbl_parents DROP CONSTRAINT tbl_parents_pkey;
       public            postgres    false    215            �           2606    29732    tbl_results tbl_results_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT tbl_results_pkey PRIMARY KEY (makq);
 F   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT tbl_results_pkey;
       public            postgres    false    216            �           2606    29739    tbl_students tbl_students_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT tbl_students_pkey PRIMARY KEY (mahs);
 H   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT tbl_students_pkey;
       public            postgres    false    217            �           2606    29746    tbl_subclass tbl_subclass_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT tbl_subclass_pkey PRIMARY KEY (mapl);
 H   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT tbl_subclass_pkey;
       public            postgres    false    218            �           2606    29753    tbl_subjects tbl_subjects_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT tbl_subjects_pkey PRIMARY KEY (ma_mon);
 H   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT tbl_subjects_pkey;
       public            postgres    false    219            �           2606    29760    tbl_teachers tbl_teachers_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_teachers
    ADD CONSTRAINT tbl_teachers_pkey PRIMARY KEY (magv);
 H   ALTER TABLE ONLY public.tbl_teachers DROP CONSTRAINT tbl_teachers_pkey;
       public            postgres    false    220            �           2606    29762 )   tbl_subjects uk_219alwpgc1hxr67m5bv4jm3nf 
   CONSTRAINT     g   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf UNIQUE (ten_mon);
 S   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf;
       public            postgres    false    219            �           2606    29828 (   tbl_students fk2asbbl0f2wks2u7av24fg34g2    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk2asbbl0f2wks2u7av24fg34g2;
       public          postgres    false    218    217    3222            �           2606    29833 (   tbl_subclass fk3ntcg1ws4utr7hym00qewjvn6    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6 FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 R   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT fk3ntcg1ws4utr7hym00qewjvn6;
       public          postgres    false    218    3210    212            �           2606    29778 *   tbl_attendance fk99ep84g5vh5cm15jaxwodig3r    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fk99ep84g5vh5cm15jaxwodig3r;
       public          postgres    false    3210    212    211            �           2606    29823 (   tbl_students fk9eijv8weg8w3y5igkgvdvkpup    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 R   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT fk9eijv8weg8w3y5igkgvdvkpup;
       public          postgres    false    3216    217    215            �           2606    29783 *   tbl_attendance fkclhehr4uqapokd3ftn3i18716    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fkclhehr4uqapokd3ftn3i18716 FOREIGN KEY (mahs) REFERENCES public.tbl_students(mahs);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fkclhehr4uqapokd3ftn3i18716;
       public          postgres    false    211    217    3220            �           2606    29813 '   tbl_results fkco0l0i8v54yeoxchmmg8p9qqp    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp FOREIGN KEY (mapc) REFERENCES public.tbl_assignment(mapc);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkco0l0i8v54yeoxchmmg8p9qqp;
       public          postgres    false    216    209    3206            �           2606    29788 *   tbl_attendance fkcqjkcfilyoagaol71wpmb7j8g    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 T   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT fkcqjkcfilyoagaol71wpmb7j8g;
       public          postgres    false    211    3222    218            �           2606    29798 )   tbl_classroom fkdqmcbxsjfc0qneow7rta783vw    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT fkdqmcbxsjfc0qneow7rta783vw FOREIGN KEY (magv) REFERENCES public.tbl_teachers(magv);
 S   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT fkdqmcbxsjfc0qneow7rta783vw;
       public          postgres    false    220    212    3228            �           2606    29803 '   tbl_license fkeftmvx3cj8xtpc3b08be039b5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5 FOREIGN KEY (maph) REFERENCES public.tbl_parents(maph);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkeftmvx3cj8xtpc3b08be039b5;
       public          postgres    false    3216    213    215            �           2606    29818 '   tbl_results fkfpu9y8umfxlw649mlqch52iv5    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5 FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT fkfpu9y8umfxlw649mlqch52iv5;
       public          postgres    false    3222    218    216            �           2606    29808 '   tbl_license fkgcu9bjptwpy90lqq4g5321y4e    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e FOREIGN KEY (mapl) REFERENCES public.tbl_subclass(mapl);
 Q   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT fkgcu9bjptwpy90lqq4g5321y4e;
       public          postgres    false    3222    218    213            �           2606    29768 *   tbl_assignment fkja966hs64yhf5gvi681chqfnq    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkja966hs64yhf5gvi681chqfnq FOREIGN KEY (ma_mon) REFERENCES public.tbl_subjects(ma_mon);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkja966hs64yhf5gvi681chqfnq;
       public          postgres    false    3224    219    209            �           2606    29763 *   tbl_assignment fkpv8oihopumgfijy54yu689bud    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkpv8oihopumgfijy54yu689bud FOREIGN KEY (ma_lop) REFERENCES public.tbl_classroom(ma_lop);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkpv8oihopumgfijy54yu689bud;
       public          postgres    false    3210    209    212            �           2606    29773 *   tbl_assignment fkq8fevylmjc9nif9o90gr5he7x    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT fkq8fevylmjc9nif9o90gr5he7x FOREIGN KEY (magv) REFERENCES public.tbl_teachers(magv);
 T   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT fkq8fevylmjc9nif9o90gr5he7x;
       public          postgres    false    3228    209    220            �           2606    29793 )   tbl_classroom fkriyu6mj3b2kcu8i2twd9xi0nq    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq FOREIGN KEY (ma_giao_vu) REFERENCES public.tbl_ministry(ma_giao_vu);
 S   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT fkriyu6mj3b2kcu8i2twd9xi0nq;
       public          postgres    false    212    214    3214            7      x������ � �      9   J   x�3�,�4204�#+0�4t��60��10�2�L*22�5�"tEFE�`�@��t��C��qqq � P      :   !   x�3t�4�4t4����u30�\1z\\\ L�      ;      x������ � �      <   9   x��u30���|��-T!$��������s��!�_�Bؑ�<���҇���q��qqq H��      =   -   x��00�񃢐�c�-�KW��?� H�@�y�\1z\\\ �y      >      x������ � �      ?   _   x��60��C ���ʇ�[�B2��V����P����� +��60B���xA^�B��Ey
G&<ܵE�1��҇�7��
ԑW���� ��,�      @      x��10��"CG�=... 7�D      A      x������ � �      B      x�s30��CG!��|�b���� ���     