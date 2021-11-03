PGDMP     0    8            	    y            primaryschool    14.0    14.0 )    :           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ;           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            <           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            =           1262    16394    primaryschool    DATABASE     q   CREATE DATABASE primaryschool WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE primaryschool;
                postgres    false            �            1259    16395    tbl_assignment    TABLE     �   CREATE TABLE public.tbl_assignment (
    mapc character varying(255) NOT NULL,
    ca character varying(255),
    magv character varying(255),
    ma_lop character varying(255),
    ma_mon character varying(255)
);
 "   DROP TABLE public.tbl_assignment;
       public         heap    postgres    false            �            1259    16402    tbl_attendance    TABLE     �   CREATE TABLE public.tbl_attendance (
    madd integer NOT NULL,
    co boolean,
    ma_lop character varying(255),
    mapl character varying(255),
    ngay timestamp without time zone
);
 "   DROP TABLE public.tbl_attendance;
       public         heap    postgres    false            �            1259    16409    tbl_classroom    TABLE     �   CREATE TABLE public.tbl_classroom (
    ma_lop character varying(255) NOT NULL,
    khoi character varying(255),
    magv character varying(255),
    ten_lop character varying(255),
    year timestamp without time zone
);
 !   DROP TABLE public.tbl_classroom;
       public         heap    postgres    false            �            1259    16416 	   tbl_grade    TABLE     t   CREATE TABLE public.tbl_grade (
    ma_khoi character varying(255) NOT NULL,
    ten_khoi character varying(255)
);
    DROP TABLE public.tbl_grade;
       public         heap    postgres    false            �            1259    16423    tbl_license    TABLE       CREATE TABLE public.tbl_license (
    magp character varying(255) NOT NULL,
    bat_dau timestamp without time zone,
    duyet boolean,
    ket_thuc timestamp without time zone,
    ly_do character varying(255),
    maph character varying(255),
    ngay timestamp without time zone
);
    DROP TABLE public.tbl_license;
       public         heap    postgres    false            �            1259    16430    tbl_ministry    TABLE     +  CREATE TABLE public.tbl_ministry (
    ma_giao_vu character varying(255) NOT NULL,
    chuc_vu character varying(255),
    dia_chi character varying(255),
    email character varying(255),
    ghi_chu character varying(255),
    sdt character varying(255),
    ten_giao_vu character varying(255)
);
     DROP TABLE public.tbl_ministry;
       public         heap    postgres    false            �            1259    16437    tbl_parents    TABLE     �   CREATE TABLE public.tbl_parents (
    maph character varying(255) NOT NULL,
    ghi_chu character varying(255),
    quan_he character varying(255),
    sdt character varying(255),
    tenph character varying(255)
);
    DROP TABLE public.tbl_parents;
       public         heap    postgres    false            �            1259    16444    tbl_results    TABLE     �   CREATE TABLE public.tbl_results (
    makq character varying(255) NOT NULL,
    diem15p double precision,
    diem1t double precision,
    diem_mieng double precision,
    mapc character varying(255),
    mapl character varying(255)
);
    DROP TABLE public.tbl_results;
       public         heap    postgres    false            �            1259    16451    tbl_students    TABLE       CREATE TABLE public.tbl_students (
    mahs character varying(255) NOT NULL,
    dia_chi character varying(255),
    ghi_chu character varying(255),
    gioi_tinh boolean,
    maph character varying(255),
    ngay_sinh timestamp without time zone,
    tenhs character varying(255)
);
     DROP TABLE public.tbl_students;
       public         heap    postgres    false            �            1259    16458    tbl_subclass    TABLE     <  CREATE TABLE public.tbl_subclass (
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
       public         heap    postgres    false            �            1259    16465    tbl_subjects    TABLE     ~   CREATE TABLE public.tbl_subjects (
    ma_mon character varying(255) NOT NULL,
    ten_mon character varying(300) NOT NULL
);
     DROP TABLE public.tbl_subjects;
       public         heap    postgres    false            �            1259    16472    tbl_teachers    TABLE     =  CREATE TABLE public.tbl_teachers (
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
       public         heap    postgres    false            ,          0    16395    tbl_assignment 
   TABLE DATA           H   COPY public.tbl_assignment (mapc, ca, magv, ma_lop, ma_mon) FROM stdin;
    public          postgres    false    209   �1       -          0    16402    tbl_attendance 
   TABLE DATA           F   COPY public.tbl_attendance (madd, co, ma_lop, mapl, ngay) FROM stdin;
    public          postgres    false    210   �2       .          0    16409    tbl_classroom 
   TABLE DATA           J   COPY public.tbl_classroom (ma_lop, khoi, magv, ten_lop, year) FROM stdin;
    public          postgres    false    211   �2       /          0    16416 	   tbl_grade 
   TABLE DATA           6   COPY public.tbl_grade (ma_khoi, ten_khoi) FROM stdin;
    public          postgres    false    212   "3       0          0    16423    tbl_license 
   TABLE DATA           X   COPY public.tbl_license (magp, bat_dau, duyet, ket_thuc, ly_do, maph, ngay) FROM stdin;
    public          postgres    false    213   ?3       1          0    16430    tbl_ministry 
   TABLE DATA           f   COPY public.tbl_ministry (ma_giao_vu, chuc_vu, dia_chi, email, ghi_chu, sdt, ten_giao_vu) FROM stdin;
    public          postgres    false    214   \3       2          0    16437    tbl_parents 
   TABLE DATA           I   COPY public.tbl_parents (maph, ghi_chu, quan_he, sdt, tenph) FROM stdin;
    public          postgres    false    215   4       3          0    16444    tbl_results 
   TABLE DATA           T   COPY public.tbl_results (makq, diem15p, diem1t, diem_mieng, mapc, mapl) FROM stdin;
    public          postgres    false    216   �5       4          0    16451    tbl_students 
   TABLE DATA           a   COPY public.tbl_students (mahs, dia_chi, ghi_chu, gioi_tinh, maph, ngay_sinh, tenhs) FROM stdin;
    public          postgres    false    217   6       5          0    16458    tbl_subclass 
   TABLE DATA           n   COPY public.tbl_subclass (mapl, diem_ky1, diem_ky2, diemtbnam, hanh_kiem, mahs, ma_lop, xep_loai) FROM stdin;
    public          postgres    false    218   �7       6          0    16465    tbl_subjects 
   TABLE DATA           7   COPY public.tbl_subjects (ma_mon, ten_mon) FROM stdin;
    public          postgres    false    219   �7       7          0    16472    tbl_teachers 
   TABLE DATA           g   COPY public.tbl_teachers (magv, dia_chi, email, ghi_chu, gioi_tinh, ngay_sinh, sdt, tengv) FROM stdin;
    public          postgres    false    220   �8       �           2606    16401 "   tbl_assignment tbl_assignment_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_assignment
    ADD CONSTRAINT tbl_assignment_pkey PRIMARY KEY (mapc);
 L   ALTER TABLE ONLY public.tbl_assignment DROP CONSTRAINT tbl_assignment_pkey;
       public            postgres    false    209            �           2606    16408 "   tbl_attendance tbl_attendance_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_attendance
    ADD CONSTRAINT tbl_attendance_pkey PRIMARY KEY (madd);
 L   ALTER TABLE ONLY public.tbl_attendance DROP CONSTRAINT tbl_attendance_pkey;
       public            postgres    false    210            �           2606    16415     tbl_classroom tbl_classroom_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tbl_classroom
    ADD CONSTRAINT tbl_classroom_pkey PRIMARY KEY (ma_lop);
 J   ALTER TABLE ONLY public.tbl_classroom DROP CONSTRAINT tbl_classroom_pkey;
       public            postgres    false    211            �           2606    16422    tbl_grade tbl_grade_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.tbl_grade
    ADD CONSTRAINT tbl_grade_pkey PRIMARY KEY (ma_khoi);
 B   ALTER TABLE ONLY public.tbl_grade DROP CONSTRAINT tbl_grade_pkey;
       public            postgres    false    212            �           2606    16429    tbl_license tbl_license_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_license
    ADD CONSTRAINT tbl_license_pkey PRIMARY KEY (magp);
 F   ALTER TABLE ONLY public.tbl_license DROP CONSTRAINT tbl_license_pkey;
       public            postgres    false    213            �           2606    16436    tbl_ministry tbl_ministry_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tbl_ministry
    ADD CONSTRAINT tbl_ministry_pkey PRIMARY KEY (ma_giao_vu);
 H   ALTER TABLE ONLY public.tbl_ministry DROP CONSTRAINT tbl_ministry_pkey;
       public            postgres    false    214            �           2606    16443    tbl_parents tbl_parents_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_parents
    ADD CONSTRAINT tbl_parents_pkey PRIMARY KEY (maph);
 F   ALTER TABLE ONLY public.tbl_parents DROP CONSTRAINT tbl_parents_pkey;
       public            postgres    false    215            �           2606    16450    tbl_results tbl_results_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_results
    ADD CONSTRAINT tbl_results_pkey PRIMARY KEY (makq);
 F   ALTER TABLE ONLY public.tbl_results DROP CONSTRAINT tbl_results_pkey;
       public            postgres    false    216            �           2606    16457    tbl_students tbl_students_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_students
    ADD CONSTRAINT tbl_students_pkey PRIMARY KEY (mahs);
 H   ALTER TABLE ONLY public.tbl_students DROP CONSTRAINT tbl_students_pkey;
       public            postgres    false    217            �           2606    16464    tbl_subclass tbl_subclass_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_subclass
    ADD CONSTRAINT tbl_subclass_pkey PRIMARY KEY (mapl);
 H   ALTER TABLE ONLY public.tbl_subclass DROP CONSTRAINT tbl_subclass_pkey;
       public            postgres    false    218            �           2606    16471    tbl_subjects tbl_subjects_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT tbl_subjects_pkey PRIMARY KEY (ma_mon);
 H   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT tbl_subjects_pkey;
       public            postgres    false    219            �           2606    16478    tbl_teachers tbl_teachers_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tbl_teachers
    ADD CONSTRAINT tbl_teachers_pkey PRIMARY KEY (magv);
 H   ALTER TABLE ONLY public.tbl_teachers DROP CONSTRAINT tbl_teachers_pkey;
       public            postgres    false    220            �           2606    16480 )   tbl_subjects uk_219alwpgc1hxr67m5bv4jm3nf 
   CONSTRAINT     g   ALTER TABLE ONLY public.tbl_subjects
    ADD CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf UNIQUE (ten_mon);
 S   ALTER TABLE ONLY public.tbl_subjects DROP CONSTRAINT uk_219alwpgc1hxr67m5bv4jm3nf;
       public            postgres    false    219            ,   �   x�]�=�0���.E�:&E*�t�:uc�.Y�(����pHl*�h}z�s�H).�{:U
�PF��u�Ϧq<O���ZiR7&��ݖ���+���wJk���96J�6 d˿��A�#銓�����&6��Oş��҉��f�d��c*�$g����ոB���N�      -      x������ � �      .   u   x�m̹�@D�x�
7 cxِ32Q���ڌ �$Ǘ�@J���Q��!����w��˙��������%�J��^���^�OE��u'tx�D"f�B�J�JvD���c�?�?9      /      x������ � �      0      x������ � �      1   �   x��1000���|���T���؆����s���+8�q:敔e�9��&f��%��r��qXZ����q�=ܵ<O!��J�������Z�`�d��d7�)�g&�I�-�+˃(C3��������f�_zi��ݭ@+oQ��8�(O!��\�=... ��F      2   �  x�]��JA���S�'���)�f�R,!MH�M�	HRXj_�؈��p����{̛xgp�-�s�9�N?%��d�KNC�k4�Z�d�xv0��.C��r8�v�{�	�FC�Ω ̈�7Y^���A�7�"��p���Tr!8�Cy�i(op��(mK��k���<���&e���r�w��;d���Z��v�&�V��)cR�d����?���=
"����XfЅH�y(ֳ
�MBy7�3UQM=�(+�5#]�4Ô~S����LX<Bl<C>��V�)iE$�Fpl�ob'���G��m��h�4^s�Ǟ���ǈ��ULaVR_g��A:ŀˈs<z�÷�MULŗ����I%Q����ǾC�����#˦�K)>���ϡ;�i�,��*��֤�s�����A���I���      3   3   x��4 C�?(
p�|��\�`y#4yc��	T�M�*o����� >��      4   �  x����N�0�g�)�AvB��Z,Q�JTL]�J��J���H}�`@�������7��v��VPE�#}���s�.��Q��Q�nр�{�"B�!鄔bBÑ�7�x����m�hc6�S�{�U�*P���>����x���2��%�.M���_�r��o���1La���ц�����M.R�fr��vx�w�pLRH� ��Ҹ��	Z���V.�W:�����T�=mKm����aC]d��s>��;>ݨ�.���Z!��8�����8�ȧx(WZؗOSGS�nb9>��g��29<�qs_O�2��$�ni��G��{�}���v�N�/��@P�Y669�߳�c� T���U�ȽG�
���*��Qi���]1���Q?���      5   R   x��1 C�?���:y\`FXTq9!TcQa����
NS$[L��0�4A2��
33̱�0�4������ ��2�      6   �   x�5��JA�띧��R�� $��Z8H�4a���Wx� ZX����!
A,�A,6/2o�1b�|���tf(J��j���w-�ɑ3��.���L�)\I�n�9��F�.b��?���O	b
1�'�8�/��#C�oG�E��Ԗ����}�K�r�G=�x����{8�qI�fs����V=��3��W���=��QK���I��i������Q:'߬���{ ��Rb      7     x�m��j�@��㧘P:�uU�������rj�F�b$C���.J!��
MJ)�]Ŧt!��7����v���ƞo�=���)!�"�8�����I����Q8��h�d�F���x��t6D�A�=B=�0!��"�f>S���U���OWo����[C�dxPܛ1>]߭��9����IL���X�K�Q	�ŕ�D14����]~������(�pU�s��w��3��lV�A���6�J��#£���J�����r��8M�r�3ǎ#����q�n��"G�%��� �o��P���
���\�rDi�+����*�8�-ζ0�G����Z�5�%�M�C[�pV��r���}���aqc���7_���I�c�_�Q��������
Wܤ���& x�m�Ҧ�G]&ydL6ߗ�<�w*��$\�v�Zf�Q`WA@������{����(=PAa#��"�%W>U�Ny8)82G	��5~Z�Z�V<C`L�}��(ߊ��/|T��2�B�P�+<�&��R���/D'��IF���M�Emka>��u�&�;g|�L` Ը�煋�p<�G��Q�-�� )�7���ԣƝΐx`7Fi4{�5uAK�̤��#�S&�Pzӧ�(sy=��ѳ$����4=����g��e���I�;�*ޠ��TK��o\r-�+��t��
�M&���i#n�E�\b�-NJf�HQ35�O�-m>b"����դ\�1�k����R���`6D3�.��P�sv��t�����     