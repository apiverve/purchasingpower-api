from setuptools import setup, find_packages

setup(
    name='apiverve_purchasingpower',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Purchasing Power calculates the inflation-adjusted value of money between any two time periods. Find out what $100 from 1990 is worth today, or calculate real returns on investments accounting for inflation.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/purchasingpower?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
